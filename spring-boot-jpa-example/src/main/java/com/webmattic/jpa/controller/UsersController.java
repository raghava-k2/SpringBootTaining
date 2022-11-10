package com.webmattic.jpa.controller;

import com.webmattic.jpa.model.Users;
import com.webmattic.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/all")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public Users getUser(@PathVariable("userId") Integer userId) throws Exception {
        return userService.getUser(userId);
    }

    @PostMapping("/user")
    public Users save(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user")
    public Users update(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void delete(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
    }
}
