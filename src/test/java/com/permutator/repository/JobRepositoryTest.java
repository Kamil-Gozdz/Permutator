package com.permutator.repository;


import com.permutator.model.entity.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JobRepositoryTest {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void shouldFindAllJobs_whenSearchForAll() {
        //given
        testEntityManager.persist(Job.builder()
                .fileName("test")
                .minLength(2)
                .maxLength(4)
                .letters("abcd")
                .stringAmount(10)
                .build());
        //when
        var jobs = jobRepository.findAll();

        //then
        Assertions.assertEquals(1, jobs.size());

    }

    @Test
    void shouldReturnActiveJobs_whenSearchForActive() {
        //given
        testEntityManager.persist(Job.builder()
                .fileName("test")
                .minLength(2)
                .maxLength(4)
                .letters("abcd")
                .stringAmount(10)
                .isRunning(true)
                .build());
        //when
        var jobs = jobRepository.getActiveJobs(true);

        //then
        Assertions.assertEquals(1, jobs.size());
    }
    @Test
    void shouldReturnNoJobs_whenSearchForActive() {
        //given
        testEntityManager.persist(Job.builder()
                .fileName("test")
                .minLength(2)
                .maxLength(4)
                .letters("abcd")
                .stringAmount(10)
                .isRunning(false)
                .build());
        //when
        var jobs = jobRepository.getActiveJobs(true);

        //then
        Assertions.assertEquals(0, jobs.size());
    }
}
