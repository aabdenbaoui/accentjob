package com.abdenan.jobportal.usermanagement.service;

import com.abdenan.jobportal.company_profile.entities.Recruiter;
import com.abdenan.jobportal.seeker_job_profile.entities.JobSeeker;
import com.abdenan.jobportal.seeker_job_profile.service.JobSeekerService;
import com.abdenan.jobportal.usermanagement.dao.UserAccountDAO;
import com.abdenan.jobportal.usermanagement.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;

@Service
public class UserManagementService {
    @Autowired
    UserAccountDAO userAccountDAO;
    @Autowired
    JobSeekerService jobSeekerService;
    public void addUserAccount(UserAccount userAccount){
//      if(getUsersService().containsKey(userAccount.getEmail())){
//          throw new IllegalArgumentException("Email already exists");
//      }
        if(userAccount.getUserType() == null){
            userAccountDAO.save(userAccount);
        }else{
            if(userAccount.getUserType().equals("Job Seeker")){
                JobSeeker jobSeeker = new JobSeeker(userAccount.getFirstName(), userAccount.getLastName());
                System.out.println(jobSeeker);
                jobSeeker.setUserAccount(userAccount);
                userAccount.setJobSeeker(jobSeeker);
                userAccountDAO.save(userAccount);
            }else if (userAccount.getUserType().equals("Recruiter")){
                Recruiter recruiter = new Recruiter(userAccount.getFirstName(), userAccount.getLastName());
                System.out.println();
                recruiter.setUserAccount(userAccount);
                userAccount.setRecruiter(recruiter);
                userAccountDAO.save(userAccount);
            }
        }
    }

    public HashMap<String, UserAccount> getAllUsersByEmail() {

        HashMap<String, UserAccount> userAccountHashMap = new HashMap<>();
        // creating Iterator named iter
        Iterator<UserAccount> iter;
        iter = userAccountDAO.findAll().iterator();
        // iterating elements of the set
        while (iter.hasNext()) {
            UserAccount nextElement = iter.next();
            userAccountHashMap.put(nextElement.getEmail(), nextElement);
        }
        return userAccountHashMap;
    }

    public void updateUser(UserAccount userAccount) {
        userAccountDAO.save(userAccount);
        System.out.println(userAccount);
    }

    public UserAccount findById(long id) {
        return userAccountDAO.findById(id).get();
    }

    public UserAccount findByEmail(String email) {
        return getAllUsersByEmail().get(email);
    }

    public UserAccount getUserById(long id) {
        return userAccountDAO.findById(id).get();
    }
}
