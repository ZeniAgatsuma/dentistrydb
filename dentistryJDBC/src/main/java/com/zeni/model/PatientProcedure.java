package com.zeni.model;

public class PatientProcedure {
    private int examinationID;
    private int patientID;
    private String examinationDate;
    private String results;
    
    public PatientProcedure(int examinationID, int patientID, String examinationDate, String results) {
        this.examinationID = examinationID;
        this.patientID = patientID;
        this.examinationDate = examinationDate;
        this.results = results;
    }
    
    // Геттери і сеттери
    public int getExaminationID() {
        return examinationID;
    }
    
    public void setExaminationID(int examinationID) {
        this.examinationID = examinationID;
    }
    
    public int getPatientID() {
        return patientID;
    }
    
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    
    public String getExaminationDate() {
        return examinationDate;
    }
    
    public void setExaminationDate(String examinationDate) {
        this.examinationDate = examinationDate;
    }
    
    public String getResults() {
        return results;
    }
    
    public void setResults(String results) {
        this.results = results;
    }
    
    @Override
    public String toString() {
        return "PatientProcedure{" +
                "examinationID=" + examinationID +
                ", patientID=" + patientID +
                ", examinationDate='" + examinationDate + '\'' +
                ", results='" + results + '\'' +
                '}';
    }
}
