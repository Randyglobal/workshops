package com.pluralsight.data;

import com.pluralsight.model.UserAuth;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    BasicDataSource basicDataSource;

//    create constructor
    public UserDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

//    Inserting user information
    public UserAuth createUser(UserAuth userAuth){
        String sql = """
                insert into customers
                (`email`, `FirstName`, `LastName`,`password`)
                values(?,?,?,?)
                """;
//        creating connection
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//            Set Parameters in prepared Statements
            preparedStatement.setString(1, userAuth.getEmail());
            preparedStatement.setString(2, userAuth.getFirstName());
            preparedStatement.setString(3, userAuth.getLastName());
            preparedStatement.setString(4, userAuth.getPassword());
//            Executing query
            int rows = preparedStatement.executeUpdate();
//            display number of rows updated
            System.out.printf("Rows updated %d\n", rows);
            try(ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()){
                    int id = keys.getInt(1);
                    System.out.printf("%d key was added\n", id);
                }
            }
            System.out.println("User saved successfully!!!");
        }catch (SQLException e){
            System.out.println("Invalid Querying" + e);
        }
        return userAuth;
    }
//    Login Logic
    public UserAuth login(String email, String password){
        String sql = "Select * from customers where email = ? and password = ?";
        UserAuth loggedUser = null;
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    String logInEmail = resultSet.getString("email");
                    String logInPassword = resultSet.getString("password");
                    loggedUser = new UserAuth(logInEmail, logInPassword);
                    System.out.println("Welcome " + logInEmail + " You are loggedIn Successfully");
                }else {
                    System.out.println("Invalid Email or password");
                }
            }
        }catch (SQLException e){
            System.out.println("Invalid Querying " + e);
            System.out.println("User does not exist");
        }
        return loggedUser;
    }
}
