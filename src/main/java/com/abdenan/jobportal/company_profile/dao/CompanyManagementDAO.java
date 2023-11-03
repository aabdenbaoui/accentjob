package com.abdenan.jobportal.company_profile.dao;

import com.abdenan.jobportal.company_profile.entities.Recruiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyManagementDAO extends CrudRepository<Recruiter, Long> {
}
