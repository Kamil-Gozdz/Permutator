package com.permutator.service.file;

import com.permutator.model.entity.Job;
import com.permutator.service.permutation.PermutationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${filepath}")
    String path;

    private final PermutationService permutationService;


    @Override
    @Transactional
    public void saveFile(Job job) throws IOException {
        Set<String> data = permutationService.getStringBySpecificData(job);
        File file = new File(path + job.getFileName() + ".txt");
        FileWriter fw = new FileWriter(file);
        for (String str : data) {
            fw.write(str + System.lineSeparator());
        }
        fw.flush();
        fw.close();
        if(file.exists()){
            job.setRunning(false);
        }
    }

    @Override
    public String getData(String fileName) {
        String strLine = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path + fileName + ".txt"))) {
            strLine = br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strLine;
    }
}
