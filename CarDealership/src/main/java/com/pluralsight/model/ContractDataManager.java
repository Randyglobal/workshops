package com.pluralsight.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        System.out.println("Saving contract... " + contract);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.txt", true))) {
            if (contract instanceof SalesContract salesContract) {
                writer.write("Sales Contract:");
                writer.newLine();
                writer.write("Date: " + salesContract.getDate());
                writer.newLine();
                writer.write("Customer Name: " + salesContract.getCustomerName());
                writer.newLine();
                writer.write("Vehicle Sold: " + salesContract.getVehicleSold());
                writer.newLine();
                writer.write("Total Amount: " + salesContract.getTotalPrice());
                writer.newLine();
                writer.write("Monthly Payment: " + salesContract.getMonthlyPayment());
                writer.newLine();
            } else {
                writer.write("Unknown Type of Contract");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error, Cannot Save... " + e.getMessage());
        }
    }
}
