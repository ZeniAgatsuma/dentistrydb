package com.zeni.model;

public class Doctor {
    private int doctorID;
    private String firstName;
    private String lastName;
    private String specialization;
    
    public Doctor(int doctorID, String firstName, String lastName, String specialization) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }
    
    // Геттери і сеттери
    public int getDoctorID() {
        return doctorID;
    }
    
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
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
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
