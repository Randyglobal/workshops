package com.pluralsight.ui;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;
import com.pluralsight.data.DealershipFileManager;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static  Scanner scanner = new Scanner(System.in);
    static  boolean userDisplay = true;
    private Dealership dealership;

//    private void init(){
//        DealershipFileManager dealershipFileManager = new DealershipFileManager();
//        dealership = dealershipFileManager.getDealership();
//
//    }
    public UserInterface(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();

        if (dealership == null){
            dealership = new Dealership("D & B Used Cars", "111 Old Benbrook Rd", "817-555-5555");
        }
    }
    public static void displayMessage(String message){
        System.out.println(message);
    }
    public void display(){
//        init();
        System.out.println("Search by..");
        while (userDisplay){
            displayMessage("1) - Price");
            displayMessage("2) - Make Model");
            displayMessage("3) - Year");
            displayMessage("4) - Color");
            displayMessage("5) - Mileage");
            displayMessage("6) - Vehicle Type");
            displayMessage("7) - All Vehicles");
            displayMessage("8) - Add Vehicle");
            displayMessage("9) - Remove Vehicle");
            displayMessage("10) - Exit");
            displayMessage("Command: ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    break;
                case 6:
                    processGetByTypeRequest();
                    break;
                case 7:
                    allVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleByVin();
                    break;
                case 10:
                    displayMessage("Exiting.......");
                    return;
            }
        }
    }
    public void processGetByPriceRequest(){
      displayMessage("Please enter price maximum range");
      double maxPrice = scanner.nextDouble();
      scanner.nextLine();
      displayMessage("Please enter price minimum range");
      double minPrice = scanner.nextDouble();
      scanner.nextLine();
      List<Vehicle> vehicles = dealership.getVehicleByPrice(maxPrice, minPrice);
      displayVehicles(vehicles);
    }
    public void processGetByMakeModelRequest(){
        displayMessage("Enter Make");
        String make = scanner.nextLine();
        displayMessage("Enter Model");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByMakeModel(make, model);
        displayVehicles(vehicles);
    }
    public void processGetByYearRequest(){
        displayMessage("Enter Maximum Year Range");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        displayMessage("Enter Minimum Year Range");
        int minYear = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByYear(maxYear, minYear);
        displayVehicles(vehicles);
    }
    public void processGetByColorRequest(){
        displayMessage("Enter color preference");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByColor(color);
        displayVehicles(vehicles);
    }
    public void processGetByTypeRequest(){
        displayMessage("Enter Vehicle type preference");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByType(vehicleType);
        displayVehicles(vehicles);
    }
    public void processAddVehicleRequest(){
        displayMessage("Enter Vehicle Vin number");
        int vin = scanner.nextInt();
        scanner.nextLine();
        displayMessage("Enter Vehicle Year");
        int year = scanner.nextInt();
        scanner.nextLine();
        displayMessage("Enter Vehicle Make");
        String make = scanner.nextLine();
        displayMessage("Enter Vehicle Model");
        String model = scanner.nextLine();
        displayMessage("Enter Vehicle Type");
        String vehicleType = scanner.nextLine();
        displayMessage("Enter Vehicle Color");
        String color = scanner.nextLine();
        displayMessage("Please enter Vehicle odometer");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        displayMessage("Please enter Vehicle Price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Vehicle vehicle = new Vehicle(vin, year,make, model, vehicleType, color, odometer, price);
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership.addVehicle(vehicle);
//        Add to file
        fileManager.saveDealership(dealership);
        displayMessage("Vehicle Added Successfully");
    }
//    Remove by vin number
    public void processRemoveVehicleByVin(){
        displayMessage("Enter Vin to delete Vehicle");
        int vin = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> vehicles = dealership.removeVehicle(vin);
        displayVehicles(vehicles);
    }

    private void displayVehicles(List<Vehicle> vehicles){
       if (vehicles == null || vehicles.isEmpty()){
           System.out.println("No vehicles available");
           return;
       }
           System.out.println("=== Vehicles ===");
           for (Vehicle vehicle : vehicles) {
               System.out.printf("Vin: %d|Year: %d|Mark: %s|Vehicle Type: %s|Color: %s|Odometer: %s|Price: %d|%.2f%n%n", vehicle.getVin(), vehicle.getYear()
                       , vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
           }
           System.out.println("=== End of Vehicles ===");
    }
    public void allVehiclesRequest(){
        if (dealership != null){
            List<Vehicle> allVehicles = dealership.getAllVehicles();
            displayVehicles(allVehicles);
        }else{
            System.out.println("Invalid Dealership");
        }
    }
}
