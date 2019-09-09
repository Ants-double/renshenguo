package com.antsdouble.gourd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyy
 * @description
 * @date 2019/9/9
 */
@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
        List<Integer> data= Arrays.asList(1,2,3,4,5,6,7);
        logger.debug(String.valueOf(data));
        model.addAttribute("num",data);
        return "index";
    }
}
