package com.company;


public class Hospital {

    private String doctor;
    private String department;
    private String date;
    private String time;

    public Hospital(String doctor, String department, String date, String time) {
        this.doctor = doctor;
        this.department = department;
        this.date = date;
        this.time = time;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return doctor+","+department+","+date+","+time;
    }
}
