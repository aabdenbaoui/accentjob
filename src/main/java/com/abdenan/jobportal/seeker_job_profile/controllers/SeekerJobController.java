package com.abdenan.jobportal.seeker_job_profile.controllers;

import com.abdenan.jobportal.seeker_job_profile.entities.*;
import com.abdenan.jobportal.seeker_job_profile.service.ExperienceService;
import com.abdenan.jobportal.seeker_job_profile.service.JobSeekerService;
import com.abdenan.jobportal.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller("/job_seeker")
public class SeekerJobController {
    @Autowired
    ExperienceService experienceService;
    @Autowired
    JobSeekerService jobSeekerService;

    @Autowired
    UserManagementService userManagementService;

    @GetMapping("/experience-info")
    public String experienceInfo(Model model, @ModelAttribute("jobSeeker") JobSeeker jobSeeker, RedirectAttributes redirectAttributes) {

        System.out.println("jobseeker"+ jobSeeker);
        List<States> states = Arrays.asList(States.values());
        UserExperience userExperience = new UserExperience();
        model.addAttribute("userExperience", userExperience);
        model.addAttribute("states", states);
        model.addAttribute("jobSeeker", jobSeeker);
        System.out.println(" JobSeeker: " + jobSeeker);
        return "experience";
    }

    @PostMapping("/save-experience-info")
    public String saveExperience(Model model, @ModelAttribute("experience") final UserExperience experience, @ModelAttribute("jobSeeker") final JobSeeker jobSeeker, RedirectAttributes redirectAttributes) {

        List<UserExperience> userExperiences = new ArrayList<>();
        userExperiences.add(experience);
        jobSeeker.setUserExperiences(userExperiences);
        experience.setJobSeeker(jobSeeker);
        jobSeekerService.saveJobSeeker(jobSeeker);
        redirectAttributes.addFlashAttribute("jobSeeker", jobSeeker);
        return "redirect:/education-info";
    }

    @GetMapping("/education-info")
    public String educationInfo(Model model, @ModelAttribute("jobSeeker") final JobSeeker jobSeeker, RedirectAttributes redirectAttributes) {
        List<Majors> majors = Arrays.asList(Majors.values());
        List<BachelorDegree> bachelorDegrees = Arrays.asList(BachelorDegree.values());

        UserEducation userEducation = new UserEducation();
        model.addAttribute("userEducation", userEducation);
        model.addAttribute("majors", majors);
        model.addAttribute("bachelorDegrees", bachelorDegrees);
        model.addAttribute("jobSeeker", jobSeeker);
        System.out.println(" JobSeeker: " + jobSeeker);
        return "education";
    }
    @PostMapping("/save-education-info")
    public String saveEducation(Model model, @ModelAttribute("education") final UserEducation education, @ModelAttribute("jobSeeker") final JobSeeker jobSeeker, RedirectAttributes redirectAttributes) {

        List<UserEducation> userEducations = new ArrayList<>();
        userEducations.add(education);
        jobSeeker.setUserEducations(userEducations);
        education.setJobSeeker(jobSeeker);
        jobSeekerService.saveJobSeeker(jobSeeker);
        redirectAttributes.addFlashAttribute("jobSeeker", jobSeeker);
        System.out.println(jobSeeker.getUserExperiences() == null);
        return "redirect:/display_job_seeker";
    }
}
