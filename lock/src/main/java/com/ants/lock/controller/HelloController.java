package com.ants.lock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyy
 * @Description hello
 * @Date 2020-02-20
 **/
@RestController
@RequestMapping(value = "/")
public class HelloController {


	@RequestMapping(value = "hello",method = RequestMethod.GET)
	public String hello(){
		return "hello";
	}
}
