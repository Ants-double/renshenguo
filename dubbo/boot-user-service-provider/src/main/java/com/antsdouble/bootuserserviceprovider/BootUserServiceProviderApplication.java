package com.antsdouble.bootuserserviceprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *功能描述
 * 导入dubbo-stater
 * dubbo其它依赖
 * @author liyy
 * @date 3/26/2019
 * @param
   * @param null
 * @return
 */
@EnableDubbo //开启基于注解的dubbo
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
