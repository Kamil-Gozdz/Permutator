package com.permutator.service.file;

import com.permutator.model.entity.Job;

import java.io.IOException;

public interface FileService {

    void saveFile(Job job) throws IOException;

    String getData(String name);

}
