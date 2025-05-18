package com.pluralsight.model;

import java.time.LocalDateTime;

public abstract class Contract {
    private LocalDateTime date;
    private String customerName;
    private String customerAddress;
    private Vehicle vehicleSold;

    public Contract(LocalDateTime date, String customerName, String customerAddress, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.vehicleSold = vehicleSold;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold( Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}

