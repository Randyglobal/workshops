package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    static LibraryManager libraryStore = new LibraryManager();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        homeScreen();
    }
//    output display

    public static void display(String message){
        System.out.println(message);
    }
//    displaying all books
    public static void homeScreen(){
        display("Please enter you name: ");
        String name = scanner.nextLine();
        display("Hello " + name + " Welcome to Library Management System," + "\n" +" Select from the Options below to proceed" + "\n");
        boolean displaySreen = true;
        while (displaySreen){
            display(" 1 - Add more books");
            display(" 2 - View all books");
            display(" 3 - Display by Serial Number");
            display(" 4 - Check Available Books");
            display(" 5 - Check Unavailable Books");
            display(" 6 - Delete Book");
            display(" 7 - Exit App");
            int res = scanner.nextInt();
            switch (res) {
                case 1:
                    libraryStore.addBooks();
                    break;
                case 2:
                    libraryStore.displayBooks();
                    break;
                case 3:
                    libraryStore.findBookBySN();
                    break;
                case 4:
                    libraryStore.availableBooks();
                    break;
                case 5:
                    libraryStore.notAvailableBooks();
                    break;
                case 6:
                    libraryStore.deleteBook();
                    break;
                case 7:
                    displaySreen = false;
                    return;
                default:
                    display("Invalid choice");
            }
        }

    }

}
