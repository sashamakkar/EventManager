package com.sashamakkar.eventmanager;

public class Event {

    private String about;
    private String attendees;
    private String date;
    private String duration;
    private String name;
    private String speciality;
    private String type;
    private String venue;


    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Event() {

    }

    public Event(String about, String attendees, String date, String duration, String name, String speciality, String type, String venue) {
        this.about = about;
        this.attendees = attendees;
        this.date = date;
        this.duration = duration;
        this.name = name;
        this.speciality = speciality;
        this.type = type;
        this.venue = venue;
    }
}
