package com.example.RateLimiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RateLimiter.model.RequestInfo;
import com.example.RateLimiter.repository.RateLimitRepository;

@Service
public class RateLimitService {

    private static final long WINDOW_SIZE_MS = 60 * 1000; // 1 minute
    private static final int MAX_REQUESTS = 5;

    @Autowired
    private RateLimitRepository ratelimitRepository;

    public boolean isAllowed(String userIp) {
        long currentTime = System.currentTimeMillis();
        RequestInfo info = ratelimitRepository.findById(userIp).orElse(new RequestInfo(userIp, 0, currentTime));

        if (currentTime - info.getWindowStartTimestamp() > WINDOW_SIZE_MS) {
            info.setWindowStartTimestamp(currentTime);
            info.setRequestCount(1);
        } else {
            info.setRequestCount(info.getRequestCount() + 1);
        }

        ratelimitRepository.save(info);
        return info.getRequestCount() <= MAX_REQUESTS;
    }
}