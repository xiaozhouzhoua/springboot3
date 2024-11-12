package org.example.springboot3;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@EnableCaching
@MapperScan("org.example.springboot3.mapper")
@SpringBootApplication(scanBasePackages = "org.example.springboot3")
public class Springboot3Application {
    public static void main(String[] args) {
        SpringApplication.run(Springboot3Application.class, args);
        log.info("Application started successfully.");
    }
}
