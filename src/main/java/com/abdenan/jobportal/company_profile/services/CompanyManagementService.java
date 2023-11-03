package com.abdenan.jobportal.company_profile.services;

import com.abdenan.jobportal.company_profile.dao.CompanyManagementDAO;
import com.abdenan.jobportal.company_profile.entities.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyManagementService {
    @Autowired
    CompanyManagementDAO companyManagementDAO;
    public void saveCompanyHR(Recruiter recruiter){
        companyManagementDAO.save(recruiter);
    }

}
