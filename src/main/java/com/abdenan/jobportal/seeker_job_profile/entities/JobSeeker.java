package com.abdenan.jobportal.seeker_job_profile.entities;

import com.abdenan.jobportal.usermanagement.entities.UserAccount;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JOB_SEEKER")
public class JobSeeker {
    @Id
    @Column(name ="job_seeker_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    private String lastName;
    private String firstName;
    @Transient
    private String fullAddress;
    @OneToMany(mappedBy="jobSeeker" , cascade = CascadeType.ALL)
    private List<UserExperience> userExperiences;
    @OneToMany(mappedBy="jobSeeker" , cascade = CascadeType.ALL)
    private List<UserEducation> userEducations;
    private String personalWebsite;
    private String gitHubUrl;
    private String twitterUrl;
    private String linkedInUrl;



    public List<UserEducation> getUserEducations() {
        return userEducations;
    }

    public void setUserEducations(List<UserEducation> userEducations) {
        this.userEducations = userEducations;
    }

    @Embedded
    private UserAddress userAddress;

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public String getFullAddress() {
        return userAddress.getUserLocationCity() + ", " + userAddress.getUserLocationState() + " "  + userAddress.getUserLocationZipCode();
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public JobSeeker() {
    }

    public JobSeeker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        userExperiences = new ArrayList<>();
        userEducations = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<UserExperience> getUserExperiences() {
        return userExperiences;
    }

    public void setUserExperiences(List<UserExperience> userExperiences) {
        this.userExperiences = userExperiences;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getPersonalWebsite() {
        return personalWebsite;
    }

    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
//                ", userExperienceSet=" + userExperienceSet +
                '}';
    }
}
