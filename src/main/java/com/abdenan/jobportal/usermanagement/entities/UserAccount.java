package com.abdenan.jobportal.usermanagement.entities;

import com.abdenan.jobportal.company_profile.entities.Recruiter;
import com.abdenan.jobportal.seeker_job_profile.entities.JobSeeker;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "USER_ACCOUNT")

public class UserAccount {
    @Id
    @Column(name = "user_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
   @Transient
    private String fullName;


    public String getFullName() {
        return convertToUpperCase(firstName) + " " + convertToUpperCase(lastName);
    }
    public String convertToUpperCase(String name){
        if(name == null){
            return "";
        }
        return name.substring(0,1).toUpperCase() + name.substring(1, name.length());
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Recruiter recruiter;
    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
     private JobSeeker jobSeeker;
    private String firstName;

    private String lastName;
    private String email;
    @Column(name = "pass_word")
    private String password;
    //Will not be created in the database. I will need to use it to confirm is the password matches
    @Transient
    private String confirmPassword;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
//    @Enumerated(EnumType.STRING)
    private String userType;

    private boolean isActive;
    private String contactNumber;
    private boolean smsNotificationActive;
    private boolean emailNotificationActive;
    @CreationTimestamp
    private LocalDate registrationDate;

    public UserAccount() {
    }
    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
    public UserAccount(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

//    public UserLog getUserLog() {
//        return userLog;
//    }
//
//    public void setUserLog(UserLog userLog) {
//        this.userLog = userLog;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isSmsNotificationActive() {
        return smsNotificationActive;
    }

    public void setSmsNotificationActive(boolean smsNotificationActive) {
        this.smsNotificationActive = smsNotificationActive;
    }

    public boolean isEmailNotificationActive() {
        return emailNotificationActive;
    }

    public void setEmailNotificationActive(boolean emailNotificationActive) {
        this.emailNotificationActive = emailNotificationActive;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}