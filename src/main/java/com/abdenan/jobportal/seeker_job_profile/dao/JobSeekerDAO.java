package com.abdenan.jobportal.seeker_job_profile.dao;

import com.abdenan.jobportal.seeker_job_profile.entities.JobSeeker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDAO extends CrudRepository<JobSeeker, Long> {
}
