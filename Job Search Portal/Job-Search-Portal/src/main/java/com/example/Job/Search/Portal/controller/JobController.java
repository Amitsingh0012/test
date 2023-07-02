package com.example.Job.Search.Portal.controller;

import com.example.Job.Search.Portal.model.Job;
import com.example.Job.Search.Portal.model.JobType;
import com.example.Job.Search.Portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;
    @GetMapping("jobs")
    public Iterable<Job> getAllRooms()
    {
        return jobService.getAllJobs();
    }
    @PostMapping("job")
    public String addRoom(@RequestBody Job job)
    {
        return jobService.addJob(job);
    }
    @PostMapping("jobs")
    public String addJobs(@RequestBody List<Job> jobs){
        return jobService.addRoms(jobs);
    }

    @GetMapping("job/{id}")
    public Job getJobById(@PathVariable Integer id){
        return jobService.getJobById(id);
    }
    @PutMapping("job/{id}/{type}")
    public String updateJobById(@PathVariable Integer id,@PathVariable JobType type){
        return jobService.updateJobById(id,type);
    }
    @DeleteMapping("job/{id}")
    public String deleteJobById(@PathVariable Integer id){
        return jobService.deleteJobById(id);
    }
    @GetMapping("job/title/{title}/jobtype/{jobType}")
    public List<Job> getRoomsByStatusAndType(@PathVariable String title, @PathVariable JobType jobType)
    {
        return jobService.getRoomsByStatusAndType(title,jobType);
    }
}
