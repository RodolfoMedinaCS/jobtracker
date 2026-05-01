package com.rodolfo.jobtracker.Controller;


import com.rodolfo.jobtracker.Entity.JobApplication;
import com.rodolfo.jobtracker.Service.JobApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/api/v1/applications")
    public void saveApplication(@RequestBody JobApplication jobApplication){
        jobApplicationService.saveApplication(jobApplication);
    }

    @GetMapping("/api/v1/applications")
    public List<JobApplication> getAllApplications(){
        return jobApplicationService.getAllApplications();
    }

}
