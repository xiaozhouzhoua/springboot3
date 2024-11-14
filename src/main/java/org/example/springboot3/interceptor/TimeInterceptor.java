package org.example.springboot3.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    private final ThreadLocal<LocalDateTime> threadLocalStart = new ThreadLocal<>();

    private final ThreadLocal<LocalDateTime> threadLocalEnd = new ThreadLocal<>();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalDateTime startTime = LocalDateTime.now();
        threadLocalStart.set(startTime);
        log.info("Request URL: {}, Start Time: {}", request.getRequestURI(), startTime.format(formatter));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LocalDateTime endTime = LocalDateTime.now();
        threadLocalEnd.set(endTime);
        log.info("Request URL: {}, End Time: {}", request.getRequestURI(), endTime.format(formatter));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalDateTime startTime = threadLocalStart.get();
        LocalDateTime endTime = threadLocalEnd.get();
        log.info("Request URL: {}, Duration: {}ms", request.getRequestURI(), Duration.between(startTime, endTime).toMillis());
    }
}
