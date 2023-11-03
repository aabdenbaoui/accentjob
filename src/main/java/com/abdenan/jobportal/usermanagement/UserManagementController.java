package com.abdenan.jobportal.usermanagement;

import com.abdenan.jobportal.seeker_job_profile.entities.JobSeeker;
import com.abdenan.jobportal.seeker_job_profile.entities.States;
import com.abdenan.jobportal.seeker_job_profile.service.JobSeekerService;
import com.abdenan.jobportal.usermanagement.entities.*;
import com.abdenan.jobportal.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserManagementController {
    @Autowired
    UserManagementService userManagementService;
    @Autowired
    JobSeekerService jobSeekerService;
    @GetMapping("/register")
    public String signUpPage(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);
        return "signup";
    }
    @PostMapping("/save")
    public String addUser(@ModelAttribute("userAccount") final UserAccount userAccount, Model model, final BindingResult mapping1BindingResult, RedirectAttributes redirectAttributes){
//        redirectAttributes.addFlashAttribute("userAccount", userAccount);
        userManagementService.addUserAccount(userAccount);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String signInPage(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        return "signin";
    }
    @PostMapping("/login")
    public String loginPage(@ModelAttribute("userDTO") final UserDTO userDTO,  final BindingResult mapping1BindingResult, RedirectAttributes redirectAttributes){
//        redirectAttributes.addFlashAttribute("userAccount", userAccount);
//        userManagementService.addUserAccount(userAccount);
        UserAccount userAccount = userManagementService.findByEmail(userDTO.getEmail());
        String userType = userAccount.getUserType();
        if(userAccount == null){
            System.out.println("email was not found");
            return  "redirect:/login";
        }else{
            System.out.println("email was found");
            redirectAttributes.addFlashAttribute("userAccount", userAccount);
            return "redirect:/personal-info";
        }
//         return "redirect:/personal-info";

    }

    @GetMapping("/personal-info")
    public String finishRegistration(@ModelAttribute("userAccount")  UserAccount userAccount, final BindingResult mapping1BindingResult, Model model){
//        System.out.println(userAccount);
        UserAccount tempUser = userManagementService.findById(userAccount.getUserId());

        List<Gender> genderList;
        genderList = Arrays.asList(Gender.values());
        List<UserType> userTypeNameList = Arrays.asList(UserType.values());
        model.addAttribute("userTypeNameList", userTypeNameList);
        UserLog userLog = new UserLog();
        model.addAttribute("genders", genderList);
        model.addAttribute("userAccount", tempUser);
        model.addAttribute("userLog", userLog);
        return "useraccount_info";
    }
    @PostMapping("/save-personal-info")
    public String savePersonalInfo(Model model, @ModelAttribute("userAccount") final UserAccount userAccount, final BindingResult mapping1BindingResult, RedirectAttributes redirectAttributes){
//        redirectAttributes.addFlashAttribute("userAccount", userAccount);
        userManagementService.addUserAccount(userAccount);
        redirectAttributes.addFlashAttribute("userAccount", userAccount);
        if(userAccount.getUserType().equals("Recruiter")){
            return "redirect:/recruiter-home";
        }else{
            return "redirect:/user-address";
        }
//        return "redirect:/user-address";
    }
    @GetMapping("/jobseeker-home")
    public String getJobSeekerHome(){
        return "jobseeker-home";
    }
    @GetMapping("/recruiter-home")
    public String getRecruiterHome(){
        return "recruiter-home";
    }
   @GetMapping("/user-address")
   public String getHomeAddress(Model model, @ModelAttribute("userAccount")  UserAccount userAccount ){
       List<States> states = Arrays.asList(States.values());
       JobSeeker jobSeeker = userAccount.getJobSeeker();
        model.addAttribute("jobSeeker", jobSeeker);
        model.addAttribute("states", states);
        return "user_personal_info";
   }
   @PostMapping("/update-jobseeker")
   public String saveHomeAddress(Model model, @ModelAttribute("jobSeeker") final JobSeeker jobSeeker, final BindingResult mapping1BindingResult, RedirectAttributes redirectAttributes){
       System.out.println(jobSeeker.getUserAddress().getUserLocationCity());
       jobSeekerService.saveJobSeeker(jobSeeker);
       redirectAttributes.addFlashAttribute("jobSeeker", jobSeeker);
       return "redirect:/experience-info";
    }
    @GetMapping("/job_seeker_home")
    public String jobSeekerHome(Model model){
        return "job_seeker_home";
    }
    @GetMapping("/display_job_seeker")
    public String getJobSeekerData(@ModelAttribute ("jobSeeker") JobSeeker jobSeeker, final BindingResult mapping1BindingResult, Model model, RedirectAttributes redirectAttributes){
        UserAccount userAccount = userManagementService.getUserById(jobSeeker.getId());
        model.addAttribute("userAccount", userAccount);
        model.addAttribute("jobSeeker", jobSeeker);
        redirectAttributes.addFlashAttribute("userAccount", userAccount);
        redirectAttributes.addFlashAttribute("jobSeeker", jobSeeker);
//        System.out.println(jobSeeker.getUserExperienceList());
//        System.out.println(jobSeeker.getUserAddress().getFullAddress());
        return "display_job_seeker";
    }

}
