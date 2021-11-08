package com.stackroute.RESTful.controller;

import com.stackroute.RESTful.model.User;
import com.stackroute.RESTful.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String userName;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity = new ResponseEntity<>("User stored successfully", HttpStatus.CREATED);
        } catch (Exception exc) {
            responseEntity  = new ResponseEntity<>(exc.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity responseEntity;
        try {
            List<User> users = userService.getAllUsers();
            responseEntity =  new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>(exc.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/users/{lastname}")
    public ResponseEntity<List<User>> getAllUsersByname(@PathVariable String lastname) {
        ResponseEntity responseEntity;
        try {
            List<User> users = userService.getUserByLastName(lastname);
            responseEntity =  new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>(exc.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
