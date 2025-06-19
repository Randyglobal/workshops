package com.pluralsight;

import com.pluralsight.config.DbConfig;
import com.pluralsight.data.VehicleDao;
import com.pluralsight.model.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

      if (args.length < 2) {
          System.err.println("Usage: java -jar YourApp.jar <db_username> <db_password>");
          System.exit(1);
      }
          String Username = args[0];
          String Password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
          dataSource.setUrl(DbConfig.getDbUrl());
          dataSource.setUsername(DbConfig.getDbUsername());
          dataSource.setPassword(DbConfig.getDbPassword());

        displayAllVehicles(dataSource);

          try {
              dataSource.close();
          }catch (SQLException e){
              System.err.println("Error closing data source: " + e.getMessage());
          }

    }
    private static void displayAllVehicles(BasicDataSource dataSource){

        VehicleDao vehicleDao = new VehicleDao(dataSource);
        List<Vehicle> vehicles = vehicleDao.getAllVehicles();

        System.out.println(formatVehiclesTable(vehicles));

    }
    public static String formatVehiclesTable(List<Vehicle> vehicles) {
        StringBuilder tableBuilder = new StringBuilder();

        // Define column widths for consistency (you can adjust these numbers)
        int vinColWidth = 17;
        int yearColWidth = 6;
        int makeColWidth = 15;
        int modelColWidth = 15;
        int colorColWidth = 12;
        int odometerColWidth = 10;
        int priceColWidth = 12; // A bit wider for price to accommodate decimals and currency

        // --- 1. Build Header Row ---
        // Using String.format() for individual column padding
        tableBuilder.append(String.format("%-" + vinColWidth + "s", "VIN"));
        tableBuilder.append(String.format(" %" + yearColWidth + "s", "YEAR"));      // Right-align header for numbers
        tableBuilder.append(String.format(" %-" + makeColWidth + "s", "MAKE"));
        tableBuilder.append(String.format(" %-" + modelColWidth + "s", "MODEL"));
        tableBuilder.append(String.format(" %-" + colorColWidth + "s", "COLOR"));
        tableBuilder.append(String.format(" %" + odometerColWidth + "s", "ODOMETER")); // Right-align header for numbers
        tableBuilder.append(String.format(" %" + priceColWidth + "s", "PRICE"));     // Right-align header for numbers
        tableBuilder.append(System.lineSeparator()); // Add a platform-independent newline

        // --- 2. Build Separator Line ---
        // Calculate total width for the separator line
        int totalLineWidth = vinColWidth + yearColWidth + makeColWidth + modelColWidth +
                colorColWidth + odometerColWidth + priceColWidth + (6 * 1); // Sum of widths + spaces between columns (assuming 1 space)
        for (int i = 0; i < totalLineWidth; i++) {
            tableBuilder.append("-");
        }
        tableBuilder.append(System.lineSeparator());

        // --- 3. Build Data Rows ---
        if (vehicles == null || vehicles.isEmpty()) {
            tableBuilder.append(String.format("%-" + totalLineWidth + "s%n", "No vehicles found."));
        } else {
            for (Vehicle vehicle : vehicles) {
                tableBuilder.append(String.format("%-" + vinColWidth + "s", vehicle.getVin()));
                tableBuilder.append(String.format(" %" + yearColWidth + "d", vehicle.getYear()));      // Right-align int
                tableBuilder.append(String.format(" %-" + makeColWidth + "s", vehicle.getMake()));
                tableBuilder.append(String.format(" %-" + modelColWidth + "s", vehicle.getModel()));
                tableBuilder.append(String.format(" %-" + colorColWidth + "s", vehicle.getColor()));
                tableBuilder.append(String.format(" %" + odometerColWidth + "d", vehicle.getOdometer())); // Right-align int
                tableBuilder.append(String.format(" %" + priceColWidth + ".2f", vehicle.getPrice()));   // Right-align float, 2 decimal places
                tableBuilder.append(System.lineSeparator());
            }
        }

        return tableBuilder.toString(); // Return the complete formatted string
    }
}
