package com.antsdouble.luzhou.service.content.provider;

import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/23
 */
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "com.antsdouble.luzhou")
@EnableTransactionManagement
@MapperScan(basePackages = "com.antsdouble.luzhou.commons.mapper")
public class ContentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentProviderApplication.class, args);
        Main.main(args);
    }
}
