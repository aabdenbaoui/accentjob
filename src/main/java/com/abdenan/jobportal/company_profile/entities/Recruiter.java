package com.abdenan.jobportal.company_profile.entities;

import com.abdenan.jobportal.usermanagement.entities.UserAccount;
import jakarta.persistence.*;

@Entity
public class Recruiter {
    @Id
    @Column(name = "recruiter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    @Transient
    private Company company;
    public Recruiter() {
    }

    public Recruiter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
