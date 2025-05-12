package Vehicle;

public class Vehicle {
    private int vin = 0;
    private int year = 0;
    private String make = "";
    private String model = "";
    private String vehicleType = "";
    private String color = "";
    private int Odometer = 0;
    private double price = 0.0;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        Odometer = odometer;
        this.price = price;
    }
}
