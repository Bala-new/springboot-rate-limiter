package com.example.RateLimiter.service;


import java.util.HashMap;
import java.util.Map;


//import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.example.RateLimiter.model.RequestInfo;

@Service
public class RateLimitService {

    private static final long WINDOW_SIZE_MS = 60 * 1000; // 1 minute
    private static final int MAX_REQUESTS = 5;


    Map<String, RequestInfo> userRequestMap= new HashMap<>();

    

    public boolean isAllowed(String userIp) {
        long currentTime = System.currentTimeMillis();
        RequestInfo info= userRequestMap.getOrDefault(userIp, new RequestInfo());

        if(currentTime-info.getWindowStartTimestamp()>WINDOW_SIZE_MS) {
            info.setWindowStartTimestamp(currentTime);
            info.setRequestCount(1);
        }else{
            info.setRequestCount(info.getRequestCount() + 1);
        }

        userRequestMap.put(userIp, info);
        return info.getRequestCount() <= MAX_REQUESTS;
    }

   
    
}
