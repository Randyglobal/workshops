package com.pluralsight.ui;

import com.pluralsight.data.UserDAO;
import com.pluralsight.model.UserAuth;
import com.pluralsight.services.UserService;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class Register {
    private static final int BORDER_WIDTH = 60; // Consistent width

    public static void displayCenteredMessage(String message) {
        int padding = (BORDER_WIDTH - message.length()) / 2;
        int leftPadding = padding;
        int rightPadding = BORDER_WIDTH - message.length() - leftPadding;

        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("|");
        for (int i = 0; i < leftPadding; i++) {
            lineBuilder.append(" ");
        }
        lineBuilder.append(message);
        for (int i = 0; i < rightPadding; i++) {
            lineBuilder.append(" ");
        }
        lineBuilder.append("|");
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

    static Scanner scanner = new Scanner(System.in);

    // to use displayCenteredMessage for all major prompts.
    public static void displaySimpleMessage(String message) {
        System.out.println(message);
    }

    public static void displayRegisterScreen(BasicDataSource basicDataSource) {
        displayBorderLine();
        displayEmptyBorderLine();
        displayCenteredMessage("--- Register New User ---");
        displayEmptyBorderLine();
        displayBorderLine();

        displayCenteredMessage("Please Enter First Name:");
        System.out.print(">>> ");
        String firstName = scanner.nextLine();

        displayCenteredMessage("Please Enter Last Name:");
        System.out.print(">>> ");
        String lastName = scanner.nextLine();

        String email = "";
//        email validation
        boolean isValidEmail = false;
        while (!isValidEmail) {
            displayCenteredMessage("Please Enter Email (e.g., user@example.com):");
            System.out.print(">>> ");
            email = scanner.nextLine();

            // Basic email validation
            if (email.contains("@") && email.contains(".")) {
                isValidEmail = true;
            } else {
                displayBorderLine();
                displayCenteredMessage("Invalid email: Email must contain '@' and a '.'.");
                displayCenteredMessage("Please try again.");
                displayEmptyBorderLine();
            }
        }

        String plainTextPassword = "";
        // Will hold the hashed password for storage
        String hashedPassword = null;
        // Dedicated flag for password validation
        boolean isValidPassword = false;

        while (!isValidPassword) {
            displayCenteredMessage("Please Enter Password:");
            displayCenteredMessage("Password must contain at least one of: #, @, or !"); // More specific
            System.out.print(">>> ");
            plainTextPassword = scanner.nextLine();

            // Password validation rules (very basic, consider more robust checks)
            if (plainTextPassword.contains("#") || plainTextPassword.contains("@") || plainTextPassword.contains("!")) {
                hashedPassword = plainTextPassword;
                isValidPassword = true;

            } else {
                displayBorderLine();
                displayCenteredMessage("Invalid password: Password must contain special characters.");
                displayCenteredMessage("Please try again.");
                displayEmptyBorderLine();
            }
        }

        displayBorderLine();
        displayEmptyBorderLine();
        displayCenteredMessage("Attempting Registration...");
        displayEmptyBorderLine();
        displayBorderLine();

        UserAuth newUser = new UserAuth(email, hashedPassword, firstName, lastName);
        UserDAO userDAO = new UserDAO(basicDataSource);
        UserService userService = new UserService(userDAO);
        userService.registerUser(newUser);

        displayBorderLine();
    }
}