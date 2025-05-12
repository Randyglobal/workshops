package com.pluralsight;

import java.util.Scanner;

public class FutureValueCalculator {
    static Scanner scanner = new Scanner(System.in);
    static int depositAmount;
    static double interestRate;
    static int numberOfYears;
    static String name;
    public static void main(String[] args) {
        userInformation();
        userOutputAndDisplay();
    }

    public static void userInformation() {
        System.out.println("Please enter your name: ");
        name = scanner.nextLine().trim();
        String newName = name.substring(0, 5);
//        System.out.println("Your name is " + newName.indexOf(name.charAt(0)));
        System.out.println("Hello " + newName + ", Welcome to the Future Value calculator");
        System.out.println("Please enter your deposit amount: $");
        depositAmount = scanner.nextInt();
        System.out.println("Please enter your interest rate: ");
        interestRate = scanner.nextDouble();
        System.out.println("Please enter the number of years: ");
        numberOfYears = scanner.nextInt();
    }
    public static void userOutputAndDisplay() {
        int daysPerYear = 365;
        double annualInterest = (interestRate / 100) / daysPerYear;
        float newAnnualInterest = (float) annualInterest;
        System.out.println("Annual Interest Rate: " + newAnnualInterest);
        int numberOfYearsPerDay = daysPerYear * numberOfYears;
        System.out.println("Number of Years Per Day: " + numberOfYearsPerDay);
        double futureValue = depositAmount * Math.pow((1 + annualInterest), numberOfYearsPerDay);
        float newFutureValue = (float) futureValue;
        double totalInterestEarned = futureValue - depositAmount;
        float newTotalInterestEarned = (float) totalInterestEarned;
        System.out.println("This is the future value calculator " + newFutureValue);
        System.out.println("If you deposit $" + depositAmount + " in CD that earns " + interestRate + "% interest and matures in " + numberOfYears + "years, your CD's ending balance will be $" + newFutureValue + " and tiy would have earned $" + newTotalInterestEarned + " in interest");

    }
}
