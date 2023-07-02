package com.example.Job.Search.Portal.service;

import com.example.Job.Search.Portal.model.Job;
import com.example.Job.Search.Portal.model.JobType;
import com.example.Job.Search.Portal.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;

    public Iterable<Job> getAllJobs() {
        return jobRepo.findAll();

    }

    public String addJob(Job job) {
        jobRepo.save(job);
        return "added";
    }

    public Job getJobById(Integer id) {
        return jobRepo.getAllJobById(id);
    }

    public String updateJobById(Integer id, JobType type) {
        Optional<Job> myJobOpt = jobRepo.findById(Long.valueOf(id));
        Job myJob = null;
        if(myJobOpt.isPresent())
        {
            myJob = myJobOpt.get();
        }
        else {
            return "Id not Found!!!";
        }
        myJob.setJobType(type);
        jobRepo.save(myJob);
        return "room type updated";
    }

    public String deleteJobById(Integer id) {
        jobRepo.deleteById(Long.valueOf(id));
        return "job deleted successfully of id "+id;
    }


    public List<Job> getRoomsByStatusAndType(String title, JobType jobType) {
        return jobRepo.findByTitleAndJobType(title, jobType);
    }

    public String addRoms(List<Job> jobs) {
        jobRepo.saveAll(jobs);
        return "rooms added"+jobs;
    }
}
