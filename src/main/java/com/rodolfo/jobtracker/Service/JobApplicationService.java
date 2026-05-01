package com.rodolfo.jobtracker.Service;

import com.rodolfo.jobtracker.Entity.JobApplication;
import com.rodolfo.jobtracker.Repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public List<JobApplication> getAllApplications(){
        return jobApplicationRepository.findAll();
    }

    public JobApplication saveApplication(JobApplication jobapplication){
        return jobApplicationRepository.save(jobapplication);
    }

}
