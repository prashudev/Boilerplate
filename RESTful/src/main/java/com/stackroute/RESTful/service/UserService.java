package com.stackroute.RESTful.service;

import com.stackroute.RESTful.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    List<User> getUserByLastName(String lastname);
}
