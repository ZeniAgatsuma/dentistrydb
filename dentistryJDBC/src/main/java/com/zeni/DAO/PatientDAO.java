package com.zeni.DAO;

import com.zeni.model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private final Connection connection;
    
    public PatientDAO(Connection connection) {
        this.connection = connection;
    }
    
    // Метод для створення пацієнта
    public void createPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO Patients (FirstName, LastName, Address, Phone, Email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getAddress());
            preparedStatement.setString(4, patient.getPhone());
            preparedStatement.setString(5, patient.getEmail());
            preparedStatement.executeUpdate();
        }
    }
    
    // Метод для оновлення пацієнта
    public void updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE Patients SET FirstName=?, LastName=?, Address=?, Phone=?, Email=? WHERE PatientID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getLastName());
            preparedStatement.setString(3, patient.getAddress());
            preparedStatement.setString(4, patient.getPhone());
            preparedStatement.setString(5, patient.getEmail());
            preparedStatement.setInt(6, patient.getPatientID());
            preparedStatement.executeUpdate();
        }
    }
    
    // Метод для видалення пацієнта за ідентифікатором
    public void deletePatient(int patientId) throws SQLException {
        String sql = "DELETE FROM Patients WHERE PatientID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, patientId);
            preparedStatement.executeUpdate();
        }
    }
    
    // Метод для отримання пацієнта за ідентифікатором
    public Patient getPatientById(int patientId) throws SQLException {
        String sql = "SELECT * FROM Patients WHERE PatientID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, patientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Patient(
                            resultSet.getInt("PatientID"),
                            resultSet.getString("FirstName"),
                            resultSet.getString("LastName"),
                            resultSet.getString("Address"),
                            resultSet.getString("Phone"),
                            resultSet.getString("Email")
                    );
                }
            }
        }
        return null;
    }
    
    // Метод для отримання всіх пацієнтів
    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM Patients";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getInt("PatientID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Address"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
                patients.add(patient);
            }
        }
        return patients;
    }
}
