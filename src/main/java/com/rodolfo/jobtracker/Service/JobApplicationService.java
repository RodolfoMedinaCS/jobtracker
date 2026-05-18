package com.rodolfo.jobtracker.Service;

import com.rodolfo.jobtracker.DTO.Stats;
import com.rodolfo.jobtracker.Entity.ApplicationStatus;
import com.rodolfo.jobtracker.Entity.JobApplication;
import com.rodolfo.jobtracker.Repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final Stats jobApplicationStats = new Stats();

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public List<JobApplication> getAllApplications(){
        return jobApplicationRepository.findAll();
    }

    public JobApplication saveApplication(JobApplication jobapplication){
        return jobApplicationRepository.save(jobapplication);
    }

    public void deleteJobApplication(Long id){
        jobApplicationRepository.deleteById(id);
    }

    public void updateApplication(Long id, JobApplication jobApplication) {
        JobApplication existing = jobApplicationRepository.findById(id).orElse(null);

        if(jobApplication.getCompany() != null){
            existing.setCompany(jobApplication.getCompany());
        }
        if(jobApplication.getJobTitle() != null){
            existing.setjobTitle(jobApplication.getJobTitle());
        }
        if(jobApplication.getStatus() != null){
            existing.setStatus(jobApplication.getStatus());
        }
        if(jobApplication.getDateApplied() != null){
            existing.setDateApplied(jobApplication.getDateApplied());
        }
        if(jobApplication.getNotes() != null){
            existing.setNotes(jobApplication.getNotes());
        }
        jobApplicationRepository.save(existing);
    }

    public Stats getStats() {
        jobApplicationStats.setTotalSubmitted(jobApplicationRepository.countByStatus(ApplicationStatus.SUBMITTED));
        jobApplicationStats.setTotalRejected(jobApplicationRepository.countByStatus(ApplicationStatus.REJECTED));
        jobApplicationStats.setTotalHired(jobApplicationRepository.countByStatus(ApplicationStatus.HIRED));
        jobApplicationStats.setTotalUnderReview(jobApplicationRepository.countByStatus(ApplicationStatus.UNDER_REVIEW));
        jobApplicationStats.setTotalOfferExtended(jobApplicationRepository.countByStatus(ApplicationStatus.OFFER_EXTENDED));
        return jobApplicationStats;
    }

    public JobApplication getApplication(Long id) {
         return jobApplicationRepository.findById(id).orElse(null);
    }
}
