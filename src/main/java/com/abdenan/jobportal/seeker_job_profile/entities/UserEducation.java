package com.abdenan.jobportal.seeker_job_profile.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EDUCATION_DETAIL")
public class UserEducation {
    @Id
    @Column(name ="education_detail_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userEducationId;
    @Column(name = "starting_date")
    private LocalDate startDate;
    @Column(name = "completion_date")
    private LocalDate endDate;
    private double gpa;

    @ManyToOne
    @JoinColumn(name="job_seeker_id", nullable=false)
    private JobSeeker jobSeeker;

    @Column(name = "major")
    private String major;
    @Column(name = "institute_university_name")
    private String institution;

    @Column(name = "certificate_degree_name")
    private String bachelorDegree;
    public UserEducation() {
    }
    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }





    public int getUserEducationId() {
        return userEducationId;
    }

    public void setUserEducationId(int userEducationId) {
        this.userEducationId = userEducationId;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getBachelorDegree() {
        return bachelorDegree;
    }

    public void setBachelorDegree(String bachelorDegree) {
        this.bachelorDegree = bachelorDegree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

}
