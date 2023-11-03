package com.abdenan.jobportal.usermanagement.entities;

public enum UserTypeName {

    JOB_SEEKER("Job Seeker"),
    RECRUITER("RECRUITER");

    private  String typeName;

    UserTypeName(String s) {
        this.typeName = s;
    }

     String getTypeName() {
        return typeName;
    }
}
