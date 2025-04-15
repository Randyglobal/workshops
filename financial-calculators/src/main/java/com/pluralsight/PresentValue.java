package com.pluralsight;

import java.util.Scanner;

public class PresentValue {
   static Scanner scanner = new Scanner(System.in);
   static int monthlyPayout;
   static double interestRate;
   static int yearsToPayOut;
    public static void main(String[] args) {
        getUsersData();
        calculateAndDisplay();
        scanner.close();
    }
    public static void getUsersData() {
        System.out.println("Please enter your monthly payout: $");
        monthlyPayout = scanner.nextInt();
        System.out.println("PLease enter your interest Rate");
        interestRate = scanner.nextDouble();
        System.out.println("Please enter your years to pay out: ");
        yearsToPayOut = scanner.nextInt();
    }
    public static void calculateAndDisplay() {
     int totalNumberOfPayments = yearsToPayOut * 12;
     double totalInterestRate = interestRate /100 / 12;
     double diffInNewmerator = 1 - Math.pow((1 + totalInterestRate), (-1 * totalNumberOfPayments));
     double newmeratorDivDenominator = diffInNewmerator / totalInterestRate;
     float newdiffInNewMerator = (float) diffInNewmerator;
     System.out.println("The newdiffInNewMerator is " + newdiffInNewMerator);
     double presentValue = monthlyPayout * newmeratorDivDenominator;
     float newPresentValue = (float) presentValue;
     System.out.println("To fund an annuity that pays $" + monthlyPayout + " monthly for " + yearsToPayOut +
             "years and earns an expected " + interestRate + " interest, you would need to invest $" + newPresentValue +  " today");
    }
}
