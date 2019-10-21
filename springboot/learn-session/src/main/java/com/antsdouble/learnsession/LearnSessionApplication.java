package com.antsdouble.learnsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class LearnSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSessionApplication.class, args);
    }

}
