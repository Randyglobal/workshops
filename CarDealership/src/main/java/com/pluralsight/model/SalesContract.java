package com.pluralsight.model;

import DealershipManager.Contract;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financed;
    private double monthlyPayment;

    public SalesContract(String date, String customerName, String customerAddress, String vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean financed, double monthlyPayment) {
        super(date, customerName, customerAddress, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financed = financed;
        this.monthlyPayment = monthlyPayment;

    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinanced() {
        return financed;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    private double calculateMonthlyPayment() {
        if (!financed) {
            return 0.0;
        }


        double principal = getTotalPrice();
        if (vehicleSold < 10000) {
            this.processingFee = 295.00;
        } else {
            this.processingFee = 495.00;
        }
        this.monthlyPayment = calculateMonthlyPayment();


        double monthlyInterestRate;
        int numberOfMonths;
        if (vehicleSold.getPrice() >= 10000) {
            monthlyInterestRate = 0.0425 / 12;
            numberOfMonths = 48;
        } else {
            monthlyInterestRate = 0.0525 / 12;
            numberOfMonths = 24;
        }

        if (monthlyInterestRate == 0) {
            return 0;
        }
    }

    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() + salesTaxAmount + recordingFee + processingFee;
    }




}
