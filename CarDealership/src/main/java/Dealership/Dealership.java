package Dealership;

import Vehicle.Vehicle;

import java.util.ArrayList;

public class Dealership {
    private String name = "";
    private String address = "";
    private String phone = "";

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max){
//        for now
        return null;
    }
    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
//        for now
        return null;
    }
    public ArrayList<Vehicle> getVehicleByYear(int min, int max){
//        for now
        return null;
    }
    public ArrayList<Vehicle> getVehicleByColor(String color){
//        for now
        return null;
    }
    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){
//        for now
        return null;
    }
    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
//        for now
        return null;
    }
    public ArrayList<Vehicle> getAllVehicles(){
//        for now
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
            this.inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
//      empty for now
    }

}
