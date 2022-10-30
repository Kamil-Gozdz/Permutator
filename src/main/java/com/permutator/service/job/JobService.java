package com.permutator.service.job;

import com.permutator.model.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();

    List<Job> getActiveJobs(boolean isRunning);

    Job saveJob(Job job);
}
