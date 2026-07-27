package com.example.pms.Business;

import com.example.pms.Model.Application;
import com.example.pms.Repository.ApplicationRepository;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.pms.Model.Job;
import com.example.pms.Model.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    private Application applicationObject;
    private ApplicationService applicationService;


    public void updateApplicationStatus(Long applicationId, String status) {
        Application Object1 = new Application();
        applicationObject = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application Not Found"));
        applicationObject.setStatus(status);
        applicationRepository.save(applicationObject);
        Optional<Application>Object = applicationService.findApplicationById(applicationId);
        Object1 = Object.get();
        Long jobId = Object1.getJobId();
        JobService newObject  = new JobService();
        Optional<Job>newObject1 = newObject.findJobById(jobId);
        Job jobObject = newObject1.get();
        jobObject.setSeats(jobObject.getSeats() - 1);
    }

    public String getApplicationStatusByapplicationId(Long applicationId) {
        Optional<Application> application = applicationRepository.findById(applicationId);
        applicationObject = application.get();
        String status = applicationObject.getStatus();
        return status;
    }
    public String getApplicationStatusBystudentName(String studentName) {
         Optional<Application> application = applicationRepository.findBystudentName(studentName);
         applicationObject = application.get();
         String status = applicationObject.getStatus();
         return status;
    }
    public String findApplicationStatusBystudentName(String studentName){
        return applicationService.getApplicationStatusBystudentName(studentName);
    }

    public String findApplcationStatusByApplicationId(Long applicationId) {
        return applicationService.getApplicationStatusByapplicationId(applicationId);
    }

    public Optional<Application> findApplicationById(Long applicationId) {
        return applicationRepository.findById(applicationId);
    }

    public Optional<Application> findApplicationBystudentName(String applicationName) {
        return applicationRepository.findBystudentName(applicationName);
    }
    public String SaveApplication(Application application) {
        applicationRepository.save(application);
        return "Application Saved Successfully";
    }
    public String DeleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
        return "Application Deleted Successfully";
    }

}
