package com.permutator.service.job;


import com.permutator.exception.NoRunningJobsFoundException;
import com.permutator.model.entity.Job;
import com.permutator.repository.JobRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
public class JobServiceTest {

    @TestConfiguration
    static class JobServiceTestConfig {

        @Bean
        JobService jobService(JobRepository jobRepository) {
            return new JobServiceImpl(jobRepository);
        }
    }

    @MockBean
    JobRepository jobRepository;

    @Autowired
    JobService jobService;

    @Test
    void whenSearchingForAllJobs_shouldReturnAllJobs() {
        //given
        List<Job> jobs = Arrays.asList(Job.builder()
                .fileName("test")
                .minLength(2)
                .maxLength(3)
                .letters("abc")
                .stringAmount(5)
                .isRunning(true)
                .build(), Job.builder()
                .fileName("test2")
                .minLength(1)
                .maxLength(2)
                .letters("abc")
                .stringAmount(6)
                .isRunning(false)
                .build());

        Mockito.when(jobRepository.findAll()).thenReturn(jobs);
        //when
        var allJobs = jobService.getAllJobs();

        //then
        Assertions.assertEquals(2, allJobs.size());

    }
    @Test
    void whenSearchingForActiveJobs_shouldReturnActiveJobs() {
        //given
        List<Job> jobs = Arrays.asList(Job.builder()
                .fileName("test")
                .minLength(2)
                .maxLength(3)
                .letters("abc")
                .stringAmount(5)
                .isRunning(true)
                .build(), Job.builder()
                .fileName("test2")
                .minLength(1)
                .maxLength(2)
                .letters("abc")
                .stringAmount(6)
                .isRunning(true)
                .build());

        Mockito.when(jobRepository.getActiveJobs(true)).thenReturn(jobs);
        //when
        var allJobs = jobService.getActiveJobs(true);

        //then
        Assertions.assertEquals(2, allJobs.size());

    }
    @Test
    void whenSearchingForActiveJobs_shouldReturnNoJobs() {

        Mockito.when(jobRepository.getActiveJobs(true)).thenReturn(Collections.emptyList());

        //when & then
        assertThatThrownBy(() -> jobService.getActiveJobs(true))
                .isInstanceOf(NoRunningJobsFoundException.class)
                .hasMessage("Żadne zadanie nie jest aktywne");

    }
}
