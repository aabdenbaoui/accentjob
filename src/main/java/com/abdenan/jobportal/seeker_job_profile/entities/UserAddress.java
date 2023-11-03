package com.abdenan.jobportal.seeker_job_profile.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class UserAddress {

    private String userLocationCity;
    private String userLocationState;
    private String userLocationZipCode;
    @Transient
    private String fullAddress;


    public UserAddress() {
    }

    public String getUserLocationCity() {
        return userLocationCity;
    }

    public void setUserLocationCity(String userLocationCity) {
        this.userLocationCity = userLocationCity;
    }

    public String getUserLocationState() {
        return userLocationState;
    }

    public void setUserLocationState(String userLocationState) {
        this.userLocationState = userLocationState;
    }

    public String getUserLocationZipCode() {
        return userLocationZipCode;
    }

    public void setUserLocationZipCode(String userLocationZipCode) {
        this.userLocationZipCode = userLocationZipCode;
    }

    public String getFullAddress() {
//        return getUserLocationCity() + ", " + getUserLocationState() + " "  + getUserLocationZipCode();
      return   "";
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

}
