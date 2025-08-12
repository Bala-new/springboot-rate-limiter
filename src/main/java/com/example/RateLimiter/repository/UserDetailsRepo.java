package com.example.RateLimiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RateLimiter.model.Users;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
