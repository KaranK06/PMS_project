package com.example.pms.Controller;


import com.example.pms.Business.InfoUpdate;
import com.example.pms.Business.JobService;
import com.example.pms.Model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/jobRole")
    ResponseEntity<List<Job>>findjob(@RequestBody InfoUpdate infoUpdate){
        List<Job>jobObject = jobService.findJobsByjobRole(infoUpdate.getJobRole());
        return new  ResponseEntity<>(jobObject, HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity<List<Job>>findAllJobs() {
        List<Job>jobObject = jobService.findAllJobs();
        return new   ResponseEntity<>(jobObject, HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<String> addJob(@RequestBody Job job){
        String message = jobService.saveJob(job);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    ResponseEntity<String> deleteJobById(@PathVariable Long Id){
        String message = jobService.deleteJobById(Id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("/companyName")
    ResponseEntity<List<Job>>findJobsByCompanyName(@RequestBody InfoUpdate info){
        List <Job> jobObject = jobService.findAllJobsByCompanyName(info.getCompanyName());
        return new  ResponseEntity<>(jobObject, HttpStatus.OK);
    }
    @GetMapping("/jobId")
    ResponseEntity<Job>findJobsByJobId(@PathVariable Long jobId){
        Optional<Job> jobObject = jobService.findJobById(jobId);
        Job job = jobObject.get();
          return new  ResponseEntity<>(job, HttpStatus.OK);
    }
}
