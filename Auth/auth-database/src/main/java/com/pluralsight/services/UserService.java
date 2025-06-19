package com.pluralsight.services;

import com.pluralsight.data.UserDAO;
import com.pluralsight.model.UserAuth;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public UserAuth registerUser(UserAuth userAuth){
        return userDAO.createUser(userAuth);
    }
}
