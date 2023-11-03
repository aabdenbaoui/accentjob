package com.abdenan.jobportal.seeker_job_profile.service;

import com.abdenan.jobportal.seeker_job_profile.dao.ExperienceDAO;
import com.abdenan.jobportal.seeker_job_profile.entities.UserExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    @Autowired
    ExperienceDAO experienceDAO;

    public void saveExperience(UserExperience experience) {
        experienceDAO.save(experience);
    }
}
