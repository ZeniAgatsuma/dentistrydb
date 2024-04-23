package com.zeni.model;

public class Appointment {
    private int appointmentID;
    private int doctorID;
    private int patientID;
    private String appointmentDate;
    
    public Appointment(int appointmentID, int doctorID, int patientID, String appointmentDate) {
        this.appointmentID = appointmentID;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.appointmentDate = appointmentDate;
    }
    
    // Геттери і сеттери
    public int getAppointmentID() {
        return appointmentID;
    }
    
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }
    
    public int getDoctorID() {
        return doctorID;
    }
    
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
    
    public int getPatientID() {
        return patientID;
    }
    
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    
    public String getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", doctorID=" + doctorID +
                ", patientID=" + patientID +
                ", appointmentDate='" + appointmentDate + '\'' +
                '}';
    }
}
