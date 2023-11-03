package com.abdenan.jobportal.usermanagement.entities;

public enum UserType {
    JOB_SEEKER("Job Seeker"), RECRUITER("Recruiter");
    private String name;
    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
