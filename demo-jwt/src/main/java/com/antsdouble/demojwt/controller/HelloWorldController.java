package com.antsdouble.demojwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
@RestController
public class HelloWorldController {

    @GetMapping(value = {"/hello"})
    public String hello() {
        return "Hello World JWT";
    }
}
