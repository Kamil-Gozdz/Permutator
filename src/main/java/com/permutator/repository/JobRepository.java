package com.permutator.repository;

import com.permutator.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("SELECT j FROM Job j where j.isRunning = true")
    List<Job> getActiveJobs(@Param("isRunning") boolean isRunning);
}
