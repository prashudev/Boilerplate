package com.stackroute.RESTful.service;

import com.stackroute.RESTful.model.User;
import com.stackroute.RESTful.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    User user;
    List<User> userList= new ArrayList<>();

    @BeforeEach
    public void initializeUser() {
        MockitoAnnotations.openMocks(this);
        user=new User(1, "Prashanth P","Dev",23);
        userList.add(user);
    }

    @Test
    public void saveUserTest() {
        when(userRepository.save(user)).thenReturn(user);
        assertEquals("Prashanth", userService.saveUser(user).getFirstName());
    }

    @Test
    public void getAllUserTest() {
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals("Prashanth", userService.getAllUsers().get(0).getFirstName());
    }

    @Test
    public void getByLastName() {
        when(userRepository.getAllByLastName("Dev")).thenReturn(userList);
        assertEquals("Prashanth", userService.getUserByLastName("Dev").get(0).getFirstName());
    }
}