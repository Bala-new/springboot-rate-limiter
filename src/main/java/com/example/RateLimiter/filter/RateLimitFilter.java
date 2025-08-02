// package com.example.RateLimiter.filter;

// import java.io.IOException;
// import jakarta.servlet.Filter;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// //import org.springframework.web.servlet.HandlerInterceptor;

// import com.example.RateLimiter.service.RateLimitService;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.ServletRequest;
// import jakarta.servlet.ServletResponse;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class RateLimitFilter implements Filter {
    
//     @Autowired
//     private RateLimitService rateLimitService;

//     // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//     //     String userIp= request.getRemoteAddr();

//     //     if(!rateLimitService.isAllowed(userIp)) {
//     //         response.setStatus(429);
//     //         response.getWriter().write("Rate limit exceeded. Try again later.");
//     //         return false;
//     //     }
        
//     //     return true;
//     // }

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) throws IOException, ServletException {
//         HttpServletRequest httpRequest = (HttpServletRequest) request;
//         HttpServletResponse httpResponse = (HttpServletResponse) response;

//         String userIp=httpRequest.getRemoteAddr();

//         if(!rateLimitService.isAllowed(userIp)) {
//             httpResponse.setStatus(429);
//             httpResponse.getWriter().write("Rate limit exceeded. Try again later.");
//             return;
//         }

//         filterchain.doFilter(request, response);
//     }
// }
