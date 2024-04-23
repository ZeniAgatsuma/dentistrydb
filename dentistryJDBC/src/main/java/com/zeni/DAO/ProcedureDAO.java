package com.zeni.DAO;

import com.zeni.model.Procedure;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProcedureDAO {
    private final Connection connection;
    
    public ProcedureDAO(Connection connection) {
        this.connection = connection;
    }
    
    // Метод для створення процедури
    public void createProcedure(Procedure procedure) throws SQLException {
        String sql = "INSERT INTO Procedures (PatientID, ProcedureDate, Description) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, procedure.getPatientID());
            preparedStatement.setString(2, procedure.getProcedureDate());
            preparedStatement.setString(3, procedure.getDescription());
            preparedStatement.executeUpdate();
        }
    }
    
    // Метод для оновлення процедури
    public void updateProcedure(Procedure procedure) throws SQLException {
        String sql = "UPDATE Procedures SET PatientID=?, ProcedureDate=?, Description=? WHERE ProcedureID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, procedure.getPatientID());
            preparedStatement.setString(2, procedure.getProcedureDate());
            preparedStatement.setString(3, procedure.getDescription());
            preparedStatement.setInt(4, procedure.getProcedureID());
            preparedStatement.executeUpdate();
        }
    }
    
    // Метод для видалення процедури за ідентифікатором
    public void deleteProcedure(int procedureId) throws SQLException {
        String sql = "DELETE FROM Procedures WHERE ProcedureID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, procedureId);
            preparedStatement.executeUpdate();
        }
    }
    
    // Метод для отримання процедури за ідентифікатором
    public Procedure getProcedureById(int procedureId) throws SQLException {
        String sql = "SELECT * FROM Procedures WHERE ProcedureID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, procedureId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Procedure(
                            resultSet.getInt("ProcedureID"),
                            resultSet.getInt("PatientID"),
                            resultSet.getString("ProcedureDate"),
                            resultSet.getString("Description")
                    );
                }
            }
        }
        return null;
    }
    
    // Метод для отримання всіх процедур
    public List<Procedure> getAllProcedures() throws SQLException {
        List<Procedure> procedures = new ArrayList<>();
        String sql = "SELECT * FROM Procedures";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Procedure procedure = new Procedure(
                        resultSet.getInt("ProcedureID"),
                        resultSet.getInt("PatientID"),
                        resultSet.getString("ProcedureDate"),
                        resultSet.getString("Description")
                );
                procedures.add(procedure);
            }
        }
        return procedures;
    }
}
