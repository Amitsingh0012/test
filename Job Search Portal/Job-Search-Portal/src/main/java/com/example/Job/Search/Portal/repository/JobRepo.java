package com.example.Job.Search.Portal.repository;

import com.example.Job.Search.Portal.model.Job;
import com.example.Job.Search.Portal.model.JobType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends CrudRepository<Job,Long> {

    Job getAllJobById(Integer id);

    List<Job> findByTitleAndJobType(String title, JobType jobType);
}

