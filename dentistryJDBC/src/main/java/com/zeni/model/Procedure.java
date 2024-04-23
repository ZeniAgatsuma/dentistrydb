package com.zeni.model;

public class Procedure {
    private int procedureID;
    private int patientID;
    private String procedureDate;
    private String description;
    
    public Procedure(int procedureID, int patientID, String procedureDate, String description) {
        this.procedureID = procedureID;
        this.patientID = patientID;
        this.procedureDate = procedureDate;
        this.description = description;
    }
    
    // Геттери і сеттери
    public int getProcedureID() {
        return procedureID;
    }
    
    public void setProcedureID(int procedureID) {
        this.procedureID = procedureID;
    }
    
    public int getPatientID() {
        return patientID;
    }
    
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    
    public String getProcedureDate() {
        return procedureDate;
    }
    
    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Procedure{" +
                "procedureID=" + procedureID +
                ", patientID=" + patientID +
                ", procedureDate='" + procedureDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
