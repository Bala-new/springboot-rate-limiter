package com.example.RateLimiter.service;

import java.util.*;


import org.springframework.stereotype.Service;

@Service
public class RateLimitService {

    private Map<String, Deque<Long>> requestinfoMap= new HashMap<>();
    private static final long WINDOW_SIZE_MS = 60 * 1000; // 1 minute
    private static final int MAX_REQUESTS = 5;

  
    public boolean isAllowed(String userIp) {
        long currentTime = System.currentTimeMillis();
        Deque<Long> timeStamps=requestinfoMap.getOrDefault(userIp, new ArrayDeque<>());

        while(!timeStamps.isEmpty() && currentTime - timeStamps.peekFirst() > WINDOW_SIZE_MS) {
            timeStamps.pollFirst();
        }
        

        if (timeStamps.size() < MAX_REQUESTS) {
            timeStamps.addLast(currentTime);
            requestinfoMap.put(userIp,timeStamps);
            return true;
        } 

        return false;
    }
}