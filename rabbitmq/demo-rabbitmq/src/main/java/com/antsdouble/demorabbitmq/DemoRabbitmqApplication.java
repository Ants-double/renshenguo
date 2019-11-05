package com.antsdouble.demorabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@EnableRabbit
public class DemoRabbitmqApplication {

    public static void main(String[] args) {
       // SpringApplication.run(DemoRabbitmqApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.environment(new StandardEnvironment());
        builder.sources(DemoRabbitmqApplication.class);
        builder.main(DemoRabbitmqApplication.class);
        builder.run(args);
    }

}
