package com.permutator.service.job;

import com.permutator.exception.NoRunningJobsFoundException;
import com.permutator.model.entity.Job;
import com.permutator.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;


    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> getActiveJobs(boolean isRunning) {
        List<Job> jobs = jobRepository.getActiveJobs(isRunning);
        if (jobs.isEmpty()) {
            throw new NoRunningJobsFoundException();
        }
        return jobs;
    }

    @Transactional
    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

}
