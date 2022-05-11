package com.stylist.rest.webservices.restfulwebservices.service;

import com.stylist.rest.webservices.restfulwebservices.model.User;

import java.util.List;

public interface UserService {
    boolean createUser(User newUser);
    User findByUsername(String username);

    List<User> getAll();
}
