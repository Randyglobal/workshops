package com.pluralsight.ui;

import com.pluralsight.model.Contract;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminUserInterface {
   static Scanner scanner = new Scanner(System.in);
   private String adminPassword = "tictac@.com";
    public static void println(String message){
        System.out.println(message);
    }
    public void display(){
        println("Enter Admin Password: ");
        String password = scanner.nextLine();
        if (!password.equals(adminPassword)){
            println("Invalid user, Please try again");
            return;
        }else {
            println("Welcome, you are signed in as Admin");
        boolean command = true;
        while (command) {
            println("\nAdmin Menu:");
            println("1) - View all Contracts");
            println("2) - List Contracts First 10 Contracts");
            println("3) - List Contract by vehicle price");
            println("4) - List Contract by customer's address");
            println("5) - Exit");
            println("Enter command");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                println("PlEASE VERIFY INPUT....");
                continue;
            }
            scanner.nextLine();
            switch (choice) {
                case 1:
                    listAllContracts();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    println("Exiting ");
            }
        }
        }
    }
    public void listAllContracts(){
        ArrayList<Contract> contracts = new ArrayList<>();
        if (contracts.isEmpty()){
            println("No information found");
        }else {
            println("\nAll Contracts");
        }
        for (Contract contract : contracts){
            println(" " + contract);
        }
    }
}
