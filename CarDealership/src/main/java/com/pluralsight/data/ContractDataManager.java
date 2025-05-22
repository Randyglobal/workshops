package com.pluralsight.data;

import com.pluralsight.model.Contract;
import com.pluralsight.model.LeaseContract;
import com.pluralsight.model.SalesContract;
import com.pluralsight.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ContractDataManager {
    String path = "data\\contracts.csv";
    public void saveContract(Contract contract) {
        System.out.println("Saving contract... " + contract);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("Contract Type: " + contract.getClass().getSimpleName());
            writer.newLine();
            if (contract instanceof SalesContract salesContract) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Vehicle soldVehicle = salesContract.getVehicleSold();
                String salesString = String.format("%s|%s|%s|%d|%s|%s|%.2f|%.2f|%.2f|%b|%.2f|%.2f|%n",
                        formatter.format(salesContract.getDate()),
                        salesContract.getCustomerName(),
                        salesContract.getCustomerAddress(),
                        soldVehicle.getVin(),
                        soldVehicle.getMake(),
                        soldVehicle.getModel(),
                        salesContract.getSalesTaxAmount(),
                        salesContract.getRecordingFee(),
                        salesContract.getProcessingFee(),
                        salesContract.isFinanced(),
                        salesContract.getMonthlyPayment(),
                        salesContract.getVehiclePrice());
                writer.write(salesString);
                System.out.println(contract.getClass().getSimpleName() + " Saved");
                writer.newLine();
            } else if (contract instanceof LeaseContract leaseContract){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Vehicle leaseVehicle = leaseContract.getVehicleSold();
                String leaseString = String.format("%s|%s|%s|%d|%s|%s|%.2f|%.2f|%.2f|%.2f|%n",
                        formatter.format(leaseContract.getDate()),
                        leaseContract.getCustomerName(),
                        leaseContract.getCustomerAddress(),
                        leaseVehicle.getVin(),
                        leaseVehicle.getMake(),
                        leaseVehicle.getModel(),
                        leaseContract.getLeaseFee(),
                        leaseContract.getMonthlyPayment(),
                        leaseContract.getEndingValue(),
                        leaseContract.getOriginalPrice());
                writer.write(leaseString);
                writer.newLine();
                System.out.println(contract.getClass().getSimpleName() + " Saved");
            }
        } catch (IOException e) {
            System.out.println("Error, Cannot Save... " + e.getMessage());
        }
    }
}
