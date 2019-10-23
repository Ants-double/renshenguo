package com.antsdouble.luzhou.service.content.consumer;

import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/23
 */
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "com.antsdouble.luzhou")
public class ContentConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentConsumerApplication.class, args);
        Main.main(args);
    }
}
