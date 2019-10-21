package com.antsdouble.learndynamicdata.controller;

import com.antsdouble.learndynamicdata.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description d
 * @date 3/29/2019
 * @Author liyy
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = {"/getdata"},method = RequestMethod.GET)
    @ResponseBody
    public Object getData(){
        return testService.getTest1();
    }

    @RequestMapping(value = {"/getdata2"},method = RequestMethod.GET)
    @ResponseBody
    public Object getData2(){
        return testService.getTest2();
    }

}
