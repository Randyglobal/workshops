package com.pluralsight.model;

public class Vehicle {
    private String vin = "";
    private int v_year = 0;
    private String mark = "";
    private String model = "";
    private String color = "";
    private int Odometer = 0;
    private double price = 0.0;



    public Vehicle(String vin, int v_year, String mark, String model, String color, int odometer, double price) {
        this.vin = vin;
        this.v_year = v_year;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.Odometer = odometer;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return v_year;
    }

    public String getMake() {
        return mark;
    }

    public String getModel() {
        return model;
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
