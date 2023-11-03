package com.abdenan.jobportal.company_profile.entities;

import jakarta.persistence.*;

@Entity
public class BusinessStream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "company_id")
    private Company company;
    private String businessStreamName;

    public BusinessStream() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getBusinessStreamName() {
        return businessStreamName;
    }

    public void setBusinessStreamName(String businessStreamName) {
        this.businessStreamName = businessStreamName;
    }
}
