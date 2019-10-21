package com.lyy.taskroot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyy.taskroot.mapper")
public class TaskRootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskRootApplication.class, args);
        System.out.println("系统启动成功");
    }

}
