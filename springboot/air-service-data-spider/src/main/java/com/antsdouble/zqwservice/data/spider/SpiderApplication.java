package com.antsdouble.zqwservice.data.spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lyy
 * @description
 * @date 2019/7/15
 */

@SpringBootApplication(scanBasePackages = "com.antsdouble.zqwservice")
@EnableTransactionManagement
@MapperScan(basePackages = "com.antsdouble.zqwservice.commons.mapper")
@EnableScheduling
public class SpiderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
    }
}
