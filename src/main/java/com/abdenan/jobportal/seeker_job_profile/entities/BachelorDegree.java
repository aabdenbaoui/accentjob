package com.abdenan.jobportal.seeker_job_profile.entities;

public enum BachelorDegree {
    BACHELOR_OF_ARTS("Bacheor of Arts"),
    BACHELOR_OF_SCIENCE("Bachlor of Science"),
    BACHELOR_OF_FINE_ARTS("Bachelor of Fine Arts");
    private String bachelorDegree;
    BachelorDegree(String bachelorDegree) {
        this.bachelorDegree = bachelorDegree;
    }

    public String getName() {
        return bachelorDegree;
    }
    @Override
    public String toString() {
        return bachelorDegree;
    }
}
