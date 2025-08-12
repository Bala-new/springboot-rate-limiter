package com.example.RateLimiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.RateLimiter.model.Users;
import com.example.RateLimiter.repository.UserDetailsRepo;

@Service
public class myUserDetailService implements UserDetailsService {
    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDetailsRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new UserPrincipal(user);
    }
    
    
}
