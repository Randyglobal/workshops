package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
   static Scanner scanner = new Scanner(System.in);
    static String name;
    static int principal;
    static double interestRate;
    static int years;
    static double totalInterest;

    public static void main(String[] args) {
        usersInformation();
        userOutputAndDisplay();
        scanner.close();
    }
    public static void usersInformation() {
        System.out.println("Do you mind entering your name? ");
        String fullName = scanner.nextLine();
//        Placing the name
        System.out.println("Hello " + fullName + ", Welcome to the mortgage calculator");
//        Getting user data
        System.out.println("Please enter your Principal: $");
        principal = scanner.nextInt();
        System.out.println("Please enter your Interest Rate: ");
        interestRate = scanner.nextDouble();
        System.out.println("Please enter your Loan Length in Years: ");
        years = scanner.nextInt();
    }
    public static void userOutputAndDisplay() {
//      Calculator function
        int numberOfMonthlyPayments = 12 * years;
        System.out.println("Number of Monthly Payment: " + numberOfMonthlyPayments);
        double monthlyInterest = interestRate / 100 / 12;
        System.out.println("Monthly Interest: " + monthlyInterest);
        double powerInterest = Math.pow((1 + monthlyInterest), numberOfMonthlyPayments);
        double monthlyPayment = principal * (monthlyInterest * powerInterest / (powerInterest -1));
        float monthlyPaymentF = (float) monthlyPayment;
        totalInterest = (monthlyPaymentF * numberOfMonthlyPayments) - principal;
//        System.out.println("A $" + principal  + " loan at " + interestRate + "%  interest for " + years + " years would have a $ " + monthlyPaymentF + "/mo payment with total interest of $" + totalInterest);
        System.out.printf("A $%d loan at %.2f%% interest for %d years would have a $%.2f monthly payment with total interest of $%.2f%n",
                principal, interestRate, years, monthlyPayment, totalInterest);

    }
}
