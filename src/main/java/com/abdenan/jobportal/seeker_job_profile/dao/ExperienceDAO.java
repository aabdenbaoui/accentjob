package com.abdenan.jobportal.seeker_job_profile.dao;

import com.abdenan.jobportal.seeker_job_profile.entities.UserExperience;
import com.abdenan.jobportal.usermanagement.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceDAO  extends CrudRepository<UserExperience, Integer> {
}
