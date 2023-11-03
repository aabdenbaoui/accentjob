package com.abdenan.jobportal.company_profile.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private long id;
    private String companyName;
    private String profileDescription;
    private LocalDate establishmentDate;
  @Transient
    private Recruiter recruiter;
    private String companyWebsiteUrl;
    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BusinessStream businessStream;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getCompanyWebsiteUrl() {
        return companyWebsiteUrl;
    }

    public void setCompanyWebsiteUrl(String companyWebsiteUrl) {
        this.companyWebsiteUrl = companyWebsiteUrl;
    }

    public BusinessStream getBusinessStream() {
        return businessStream;
    }

    public void setBusinessStream(BusinessStream businessStream) {
        this.businessStream = businessStream;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}
