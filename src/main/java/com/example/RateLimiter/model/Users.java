package com.example.RateLimiter.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Users {
    
    @Id
    private int id;
    private String username;
    private String password;
    private String role;
    
}
