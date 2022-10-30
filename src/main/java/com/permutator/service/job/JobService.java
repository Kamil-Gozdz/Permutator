package com.permutator.service.job;

import com.permutator.model.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();

    Job saveJob(Job job);
}
