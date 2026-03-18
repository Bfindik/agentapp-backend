package com.example.agentapp.model;

public class Guide {
    private String name;
    private String surName;
    private String TC;
    private String licenseNumber;
    private String registrationNumber;
    private String phoneNumber;
    private String email;
    private String cost;//per day

    public Guide(String name, String surName, String TC, String licenseNumber, String registrationNumber, String phoneNumber, String email, String cost) {
        this.name = name;
        this.surName = surName;
        this.TC = TC;
        this.licenseNumber = licenseNumber;
        this.registrationNumber = registrationNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", TC='" + TC + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
