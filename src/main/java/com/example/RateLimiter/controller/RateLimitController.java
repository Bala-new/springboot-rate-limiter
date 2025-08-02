package com.example.RateLimiter.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RateLimitController {
    
    @GetMapping("api/test")
    public ResponseEntity<String> checkRateLimit() {
        return ResponseEntity.ok("You're allowed...");
    }
}
