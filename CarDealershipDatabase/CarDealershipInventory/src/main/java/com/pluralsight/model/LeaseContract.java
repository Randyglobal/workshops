package com.pluralsight.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeaseContract extends Contract{
    private String vin;
    private LocalDate lease_start_date;
    private LocalDate lease_end_date;
    private int mileage_allowance;
    private int customer_id;
    private double leaseFee;
    private double monthlyPayment;
    private double endingValue;
    private double originalPrice;
    private double leaseInterestRate = 0.04;
    private int leaseMonthTerm = 36;

    public LeaseContract(LocalDateTime date, String customerName, String customerAddress, Vehicle vehicleSold, String vin, LocalDate lease_start_date, LocalDate lease_end_date, double monthlyPayment, int customer_id, int leaseMonthTerm, int mileage_allowance) {
        super(date, customerName, customerAddress, vehicleSold);
        this.vin = vin;
        this.lease_start_date = lease_start_date;
        this.lease_end_date = lease_end_date;
        this.monthlyPayment = monthlyPayment;
        this.customer_id = customer_id;
        this.leaseMonthTerm = leaseMonthTerm;
        this.mileage_allowance = mileage_allowance;
    }

    public LeaseContract(LocalDateTime date, String customerName, String customerAddress, Vehicle vehicleSold, double leaseFee, double monthlyPayment, double endingValue, double originalPrice) {
        super(date, customerName, customerAddress, vehicleSold);
        this.leaseFee = originalPrice * 0.07;
        this.monthlyPayment = TotalMonthlyPayment();
        this.endingValue = originalPrice * 0.05;
        this.originalPrice = originalPrice;
    }

    public String getVin() {
        return vin;
    }

    public LocalDate getLease_start_date() {
        return lease_start_date;
    }

    public LocalDate getLease_end_date() {
        return lease_end_date;
    }

    public int getMileage_allowance() {
        return mileage_allowance;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public double getLeaseInterestRate() {
        return leaseInterestRate;
    }

    public int getLeaseMonthTerm() {
        return leaseMonthTerm;
    }




    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    private  double TotalMonthlyPayment(){
//        Formular = P [i(1 + i)^n] / [(1 + i)^n - 1]
        /*
        * Where
        * P = principal
        * i = interest
        * n = number of payment (in months)
        * */
        double principal = originalPrice;
        double monthlyInterst = leaseInterestRate / 12;
        int numberOfMonths = leaseMonthTerm;
        double numberOfPaymentPerMonth = monthlyInterst * numberOfMonths;
//        Taken Math.pow as (1 + monthlyInterst, numberOfPayments) because to get the accurate value of n,
//        we will need the given number of months, which is 36 and the monthlyInterest
        double numerator = principal * monthlyInterst * Math.pow( 1 + monthlyInterst, numberOfMonths);
//        double denominator = (1 + monthlyInterst) * Math.pow( 1 + monthlyInterst, numberOfMonths) - 1;
        double denominator = Math.pow( 1 + monthlyInterst, numberOfMonths) - 1;
        if (numerator == 0 ||denominator == 0){
            return 0;
        }
        return numerator / denominator;
    }

    @Override
    public double getTotalPrice() {
        return (monthlyPayment * leaseMonthTerm) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}
