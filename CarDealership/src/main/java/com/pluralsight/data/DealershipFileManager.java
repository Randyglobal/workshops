package com.pluralsight.data;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    String path = "data\\inventory.csv";
//    Dealership dealership = new Dealership();
    public Dealership getDealership(){
        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader( new FileReader(path));
            String line;
//            First line reads dealership info
            if ((line = reader.readLine()) != null){
                String[] dealershipDeatils = line.split("\\|");
                if (dealershipDeatils.length == 3){
                    dealership = new Dealership(dealershipDeatils[0], dealershipDeatils[1], dealershipDeatils[2]);
                    String name = dealership.getName();
                    String address = dealership.getAddress();
                    String phone = dealership.getPhone();
//                    System.out.printf("%s|%s|%s|%.2f%n", name, address, phone);

                }else{
                    System.out.println("Invalid line1");
                    return null;
                }
            }else{
                System.out.println("Invalid line2");
                return null;
            }

            while ((line = reader.readLine()) != null){
                String[] vehicleDetails = line.split("\\|");
                if (vehicleDetails.length == 8){
                    try {
                        int vin = Integer.parseInt(vehicleDetails[0].trim());
                        int year = Integer.parseInt(vehicleDetails[1].trim());
                        String mark = vehicleDetails[2].trim();
                        String model = vehicleDetails[3].trim();
                        String vehicleType = vehicleDetails[4].trim();
                        String color = vehicleDetails[5].trim();
                        int odometer = Integer.parseInt(vehicleDetails[6].trim());
                        double price = Double.parseDouble(vehicleDetails[7].trim());
                        System.out.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n%n", vin, year, mark, model, vehicleType, color, odometer, price);
                    } catch (Exception e) {
                        System.out.println("Invalid line3");
                    }
                }else {
                    System.out.println("Invalid line4");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid File5");
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership){
//    checking if dealership is null
        if (dealership == null){
            System.out.println("Dealership is empty");
            return;
        }
        try {
//            Writing dealership in file
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(String.format("%s|%s|%s|%n", dealership.getName(), dealership.getPhone(), dealership.getAddress()));
//            adding vehicles in file
            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
            if (vehicles != null && !vehicles.isEmpty()){
                for (Vehicle vehicle : vehicles){
                    writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f%n%n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
                }
            }
            System.out.println("Dealership data saved");
            writer.close();


        } catch (IOException e) {
            System.out.println("Invalid program" + e.getMessage());
        }
    }
}
