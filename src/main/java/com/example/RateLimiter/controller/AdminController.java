package com.example.RateLimiter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.RateLimiter.model.Users;
import com.example.RateLimiter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;
    
    @PostMapping("/add-user")
    public String addUser(@RequestBody Users user) {
        userService.addUser(user);
        return "User added successfully";
    }
    
}
