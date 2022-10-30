package com.permutator.controller;

import com.permutator.model.entity.Job;
import com.permutator.service.file.FileService;
import com.permutator.service.job.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    private final FileService fileService;

    @GetMapping("/get/all")
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/post")
    public Job createJob(@RequestBody Job job) throws IOException {
        var response = jobService.saveJob(job);
        fileService.saveFile(job);
        return response;
    }

    @GetMapping("/get/results/{fileName}")
    public String readData(@PathVariable String fileName) {
        return fileService.getData(fileName);
    }
}
