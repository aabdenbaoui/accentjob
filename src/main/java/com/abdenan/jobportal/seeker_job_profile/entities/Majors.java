package com.abdenan.jobportal.seeker_job_profile.entities;

public enum Majors {
    COMMUNICATION("BA","Communication"),
    EDUCATION("BA","Education"),
    ENGLISH("BA","English"),

    FOREIGN_LANGUAGES("BA","Foreign languages"),
    PHILOSOPHY("BA","Philosophy"),
    PHSYCOLOGY("BA","Psychology"),
   SOCIOLOGY("BA","Sociology"),
    BIOLOGY("BS","Biology"),
    BUSINESS("BS", "Busines"),
    CHEMISTRY("BS","Chemistry"),
    COMPUTER_SCIENCE("BS", "Computer Science"),
    ENGINEERING("BS", "Engineering"),
    MATHEMATICS("BS","Mathematics" ),
    NURSING("BS", "Nursing"),
    PHYSICS("BS", "Physics"),
    CREATIVE_WRITING("BFA", "Creative writing"),
    FILM_AND_PHOTOGRAPHY("BFA", "Film and photography"),
    MUSIC("BFA", "Music"),
   THEATER_AND_DANCE("BFA", "Theater and dance"),
    VISUAL_ARTS("BFA", "Visual arts");



   private String type;
   private String degree;

    Majors(String type, String degree) {
        this.degree = degree;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getDegree() {
        return degree;
    }
}
