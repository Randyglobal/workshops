package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max){
//        for now
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                result.add(vehicle);
            }
        }
            return result;
    }
    public List<Vehicle> getVehicleByMakeModel(String make, String model){
//        for now
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                result.add(vehicle);
            }
        }
        return result;
    }
    public List<Vehicle> getVehicleByYear(int min, int max){
//        for now
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public List<Vehicle> getVehicleByColor(String color){
//        for now
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                result.add(vehicle);
            }
        }
        return result;
    }
    public List<Vehicle> getVehicleByMileage(int min, int max){
//        for now
        return null;
    }
    public List<Vehicle> getVehicleByType(String vehicleType){
//        for now
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getAllVehicles(){
//        for now
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
            this.inventory.add(vehicle);
    }
    public List<Vehicle> removeVehicle(int vin){
//      empty for now
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getVin() == vin){
                result.remove(vehicle);
            }
        }
        return result;
    }

}
