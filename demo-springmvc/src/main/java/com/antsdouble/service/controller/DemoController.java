package com.antsdouble.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/18
 */
@Controller
public class DemoController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
