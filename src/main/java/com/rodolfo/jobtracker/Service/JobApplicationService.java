package com.rodolfo.jobtracker.Service;

import com.rodolfo.jobtracker.Entity.JobApplication;
import com.rodolfo.jobtracker.Repository.JobApplicationRepository;

import java.util.List;

public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public List<JobApplication> getAllApplications(){
        return jobApplicationRepository.findAll();
    }

}
