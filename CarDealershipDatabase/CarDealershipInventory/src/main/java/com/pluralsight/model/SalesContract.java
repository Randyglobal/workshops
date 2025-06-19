package com.pluralsight.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SalesContract extends Contract {
    private int vin;
    private LocalDate sale_date;
    private double sale_price;
    private int customer_id;
    private int salesperson_id;

    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financed;
    private double monthlyPayment;
    private double vehiclePrice;

    public SalesContract(LocalDateTime date, String customerName, String customerAddress, Vehicle vehicleSold, int vin, LocalDate sale_date, double sale_price, int customer_id, int salesperson_id) {
        super(date, customerName, customerAddress, vehicleSold);
        this.vin = vin;
        this.sale_date = sale_date;
        this.sale_price = sale_price;
        this.customer_id = customer_id;
        this.salesperson_id = salesperson_id;
    }

    public SalesContract(LocalDateTime date, String customerName, String customerAddress, Vehicle vehicleSold,
                         double salesTaxAmount, double recordingFee, double processingFee,
                         boolean financed, double monthlyPayment, double vehiclePrice) {
        super(date, customerName, customerAddress, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financed = financed;
        this.monthlyPayment = monthlyPayment;
        this.vehiclePrice = vehiclePrice;
    }

    public int getVin() {
        return vin;
    }

    public LocalDate getSale_date() {
        return sale_date;
    }

    public double getSale_price() {
        return sale_price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getSalesperson_id() {
        return salesperson_id;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public double getTotalPrice() {
        return vehiclePrice + salesTaxAmount + recordingFee + processingFee;
    }

    private double calculateMonthlyPayment() {
        if (!financed) {
            return 0.0;
        }
        double principal = getTotalPrice();
        double monthlyInterestRate;
        int numberOfMonths;

        if (vehiclePrice >= 10000) {
            monthlyInterestRate = 0.0425 / 12;
            numberOfMonths = 48;
        } else {
            monthlyInterestRate = 0.0525 / 12;
            numberOfMonths = 24;
        }

        double numerator = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths);
        double denominator = Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1;
        return numerator / denominator;
    }
}
