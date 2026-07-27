package com.example.pms.Business;

import com.example.pms.Model.Job;
import com.example.pms.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

   public List<Job> findJobsByjobRole(String jobRole) {
        return jobRepository.findByjobRole(jobRole);
    }

    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    public String saveJob(Job job) {
        jobRepository.save(job);
        return "job saved successfully";
    }
    public String deleteJobById(Long jobId) {
        jobRepository.deleteById(jobId);
        return "Job is Deleted";
    }
    public List<Job> findAllJobsByCompanyName(String companyName) {
        return jobRepository.findBycompanyName(companyName);
    }
    public Optional<Job> findJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }
}
