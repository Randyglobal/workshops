package DealershipManager;

import Dealership.Dealership;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    static  Scanner scanner = new Scanner(System.in);
    static  boolean userDisplay = true;
    private Dealership dealership;

    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();

    }
    public static void displayMessage(String message){
        System.out.println(message);
    }
    public void display(){
        init();
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
            displayMessage("Command: ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    allVehiclesRequest();
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
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
            ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
            displayVehicles(allVehicles);
        }else{
            System.out.println("Invalid Dealership");
        }
    }
}
