package com.example.RateLimiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RateLimiter.model.Users;
import com.example.RateLimiter.repository.UserDetailsRepo;

@Service
public class UserService {

    @Autowired
    UserDetailsRepo repo;

    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);

    public void addUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
    
}
