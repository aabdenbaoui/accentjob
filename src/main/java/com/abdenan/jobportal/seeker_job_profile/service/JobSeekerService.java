package com.abdenan.jobportal.seeker_job_profile.service;

import com.abdenan.jobportal.seeker_job_profile.dao.JobSeekerDAO;
import com.abdenan.jobportal.seeker_job_profile.entities.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {
    @Autowired
    JobSeekerDAO jobSeekerDAO;

    public void saveJobSeeker(JobSeeker jobSeeker){
        jobSeekerDAO.save(jobSeeker);
    }

    public JobSeeker findJobSeeker(long userId) {
        return jobSeekerDAO.findById(userId).get();
    }

    public JobSeeker getJobSeekerById(long id) {
        return  jobSeekerDAO.findById(id).get();
    }
}
