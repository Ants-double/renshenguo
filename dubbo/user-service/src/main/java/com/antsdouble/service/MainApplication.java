package com.antsdouble.service;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @ClassName MainApplication
 * @Description main
 * @date 3/26/2019
 * @Author liyy
 * @Version 1.0
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc=new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();
        System.in.read();
    }
}
