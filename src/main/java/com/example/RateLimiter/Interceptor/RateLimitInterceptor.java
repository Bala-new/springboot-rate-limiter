package com.example.RateLimiter.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.RateLimiter.service.RateLimitService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    @Autowired
    RateLimitService rateLimitService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user=SecurityContextHolder.getContext().getAuthentication().getName();

        if(!rateLimitService.isAllowed(user)) {
            response.setStatus(429);
            response.getWriter().write("Rate limit exceeded. Try again later.");
            return false;
        }
        
        return true;
    }
    
    
}
