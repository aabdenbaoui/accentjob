package com.abdenan.jobportal.seeker_job_profile.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EXPERIENCE_DETAIL")
public class UserExperience {

    @Id
    @Column(name = "experience_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String jobTitle;
    private String CompanyName;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(name = "is_current_job")
    private boolean isCurrentJob;
    private String jobLocationCity;
    private String jobLocationState;
    private String jobLocationZipCode;
    private String description;
    @Column(name = "current_salary")
    private double salary;

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @ManyToOne
    @JoinColumn(name="job_seeker_id", nullable=false)
    private JobSeeker jobSeeker;
    public UserExperience() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getJobLocationZipCode() {
        return jobLocationZipCode;
    }

    public void setJobLocationZipCode(String jobLocationZipCode) {
        this.jobLocationZipCode = jobLocationZipCode;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean getIsCurrentJob() {
        return isCurrentJob;
    }

    public void setIsCurrentJob(boolean currentJob) {
        this.isCurrentJob = currentJob;
    }

    public String getJobLocationCity() {
        return jobLocationCity;
    }

    public void setJobLocationCity(String jobLocationCity) {
        this.jobLocationCity = jobLocationCity;
    }

    public String getJobLocationState() {
        return jobLocationState;
    }

    public void setJobLocationState(String jobLocationState) {
        this.jobLocationState = jobLocationState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserExperience{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isCurrentJob=" + isCurrentJob +
                ", jobLocationCity='" + jobLocationCity + '\'' +
                ", jobLocationState='" + jobLocationState + '\'' +
                ", jobLocationZipCode='" + jobLocationZipCode + '\'' +
                ", description='" + description + '\'' +
                ", salary='" + salary + '\'' +
//                ", jobSeeker=" + jobSeeker +
                '}';
    }
}
