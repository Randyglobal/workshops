package com.pluralsight.ui;

import com.pluralsight.data.UserDAO;
import com.pluralsight.model.UserAuth;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner; // Import Scanner

public class Login {
    private static final int BORDER_WIDTH = 60;

    public static void displayCenteredMessage(String message) {
        // Calculate padding on each side
        int padding = (BORDER_WIDTH - message.length()) / 2;
        // Adjust if message length is odd
        int leftPadding = padding;
        int rightPadding = BORDER_WIDTH - message.length() - leftPadding;

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


//      Displays a horizontal border line.

    public static void displayBorderLine() {
        StringBuilder border = new StringBuilder();
        border.append("+");
        for (int i = 0; i < BORDER_WIDTH; i++) {
            border.append("-");
        }
        border.append("+");
        System.out.println(border.toString());
    }


//     Displays empty space within the border for aesthetic purposes.

    public static void displayEmptyBorderLine() {
        StringBuilder emptyLine = new StringBuilder();
        emptyLine.append("|");
        for (int i = 0; i < BORDER_WIDTH; i++) {
            emptyLine.append(" ");
        }
        emptyLine.append("|");
        System.out.println(emptyLine.toString());
    }

    public static void displaySimpleMessage(String message) {
        System.out.println(message);
    }

    public static void login(BasicDataSource basicDataSource) {

        Scanner scanner = new Scanner(System.in);

        String email = "";
        String password = "";
        boolean isValidEmail = false;

        displayBorderLine();
        displayEmptyBorderLine();
        displayCenteredMessage("--- User Login ---");
        displayEmptyBorderLine();

        while (!isValidEmail) {
            displayCenteredMessage("Enter Email (e.g., user@example.com):");
            displayBorderLine();
            System.out.print(">>> ");
            email = scanner.nextLine();

            if (email.contains("@") && email.contains(".")) { // Basic check, consider regex for robustness
                isValidEmail = true;
            } else {
                displayBorderLine();
                displayCenteredMessage("Invalid email: Email must contain '@' and a '.'.");
                displayCenteredMessage("Please try again.");
                displayEmptyBorderLine();
            }
        }

        displayBorderLine();
        displayEmptyBorderLine();
        displayCenteredMessage("Enter Password:");
        displayBorderLine(); // Just a visual separator before input
        System.out.print(">>> "); // Prompt for input
        password = scanner.nextLine();


        UserDAO userDAO = new UserDAO(basicDataSource);
        // CRITICAL FIX: Capture the return value from userDAO.login!
        UserAuth loggedInUser = userDAO.login(email, password); // This still passes plain text password (INSECURE)

        displayBorderLine();
        if (loggedInUser != null) {
            displayCenteredMessage("Welcome, " + loggedInUser.getEmail() + "!");
            displayCenteredMessage("You are logged in successfully!");
            displayEmptyBorderLine();
            displayBorderLine();
            // Here you would typically navigate to the main application menu/dashboard
        } else {
            displayCenteredMessage("Login Failed!");
            displayCenteredMessage("Invalid email or password. Please try again.");
            displayEmptyBorderLine();
            displayBorderLine();
        }

        // Always close the scanner if it was created within this method
        scanner.close();
    }
}