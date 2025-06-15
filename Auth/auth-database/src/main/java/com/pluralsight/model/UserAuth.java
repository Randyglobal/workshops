package com.pluralsight.model;

public class UserAuth {
    private String email = "";
    private String password = "";
    private String firstName = "";
    private String lastName = "";

    public UserAuth(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserAuth(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
