package com.example.RateLimiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RateLimiter.model.RequestInfo;

@Repository
public interface RateLimitRepository extends JpaRepository<RequestInfo, String> {
    
}
