package com.pluralsight;

import com.pluralsight.ui.Login;
import com.pluralsight.ui.Register;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static final int BORDER_WIDTH = 60;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar YourApp.jar <db_username> <db_password>");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/auth");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        displayHomeScreen(basicDataSource);

        scanner.close();
        try {
            basicDataSource.close();
        } catch (java.sql.SQLException e) {
            System.err.println("Error closing data source: " + e.getMessage());
        }
    }


    public static void displayCenteredMessage(String message) {
        // Calculate padding on each side
        int padding = (BORDER_WIDTH - message.length()) / 2;
        // Adjust if message length is odd
        int leftPadding = padding;
        int rightPadding = BORDER_WIDTH - message.length() - leftPadding;

        // Build the string with StringBuilder
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("|"); // Left border
        for (int i = 0; i < leftPadding; i++) {
            lineBuilder.append(" ");
        }
        lineBuilder.append(message);
        for (int i = 0; i < rightPadding; i++) {
            lineBuilder.append(" ");
        }
        lineBuilder.append("|"); // Right border

        System.out.println(lineBuilder.toString());
    }


    public static void displayBorderLine() {
        StringBuilder border = new StringBuilder();
        border.append("+");
        for (int i = 0; i < BORDER_WIDTH; i++) {
            border.append("-");
        }
        border.append("+");
        System.out.println(border.toString());
    }

    public static void displayEmptyBorderLine() {
        StringBuilder emptyLine = new StringBuilder();
        emptyLine.append("|");
        for (int i = 0; i < BORDER_WIDTH; i++) {
            emptyLine.append(" ");
        }
        emptyLine.append("|");
        System.out.println(emptyLine.toString());
    }

    private static void displayHomeScreen(BasicDataSource basicDataSource) {
        boolean request = true;
        int response;
        while (request) {
            displayBorderLine();
            displayEmptyBorderLine();
            displayCenteredMessage("Hello, Welcome to Auth App!");
            displayEmptyBorderLine();
            displayCenteredMessage("1) - LOGIN");
            displayCenteredMessage("2) - REGISTER");
            displayCenteredMessage("3) - EXIT");
            displayEmptyBorderLine();
            displayBorderLine();

            System.out.print("Enter Command: ");
            response = scanner.nextInt();
            scanner.nextLine();

            switch (response) {
                case 1:
                    Login.login(basicDataSource);
                    break;
                case 2:
                    Register.displayRegisterScreen(basicDataSource);
                    break;
                case 3:
                    request = false; 
                    displayCenteredMessage("Goodbye!");
                    break;
                default:
                    displayCenteredMessage("Invalid command. Please try again.");
            }
            System.out.println();
        }
    }
}