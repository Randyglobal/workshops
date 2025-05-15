package com.pluralsight.model;

public class Vehicle {
    private int vin = 0;
    private int year = 0;
    private String mark = "";
    private String model = "";
    private String vehicleType = "";
    private String color = "";
    private int Odometer = 0;
    private double price = 0.0;

    public Vehicle(int vin, int year, String mark, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.mark = mark;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        Odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return Odometer;
    }

    public double getPrice() {
        return price;
    }
}
