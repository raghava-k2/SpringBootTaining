package com.webmattic.jpa.controller;

import com.webmattic.jpa.model.Users;
import com.webmattic.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/all")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
}
