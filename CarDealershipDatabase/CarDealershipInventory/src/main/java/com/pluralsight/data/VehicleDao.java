package com.pluralsight.data;

import com.pluralsight.model.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    BasicDataSource dataSource;

    public VehicleDao(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Vehicle> getAllVehicles(){
        String sql =
                "select vin, v_year, make, model, color, mileage, price from vehicles";
        List<Vehicle> vehicles = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                     String vin = resultSet.getString("vin");
                     int v_year = resultSet.getInt("v_year");
                     String mark = resultSet.getString("make");
                     String model = resultSet.getString("model");
                     String color = resultSet.getString("color");
                     int mileage = resultSet.getInt("mileage");
                     double price = resultSet.getDouble("price");
                     Vehicle vehicle = new Vehicle(vin, v_year, mark, model, color, mileage, price);
                     vehicles.add(vehicle);
                }
            }
        }catch (SQLException e){
            System.err.println("Database error: Could not retrieve all vehicles.");
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
        }
        return vehicles;
    }
}
