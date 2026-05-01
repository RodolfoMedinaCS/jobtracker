package com.rodolfo.jobtracker.Repository;

import com.rodolfo.jobtracker.Entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}
