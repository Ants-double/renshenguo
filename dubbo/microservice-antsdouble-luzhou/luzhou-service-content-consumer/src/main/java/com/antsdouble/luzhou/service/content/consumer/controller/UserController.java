package com.antsdouble.luzhou.service.content.consumer.controller;

import com.antsdouble.util.AntsArrayUtil;
import com.antsdouble.content.api.UserServer;
import com.antsdouble.luzhou.commons.domain.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/23
 */
@RestController
@RequestMapping(value = "/")
public class UserController {

    @Reference(version = "${services.versions.content.v1}")
    private UserServer userServer;



    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getUser(){
        String s = Arrays.toString(AntsArrayUtil.convertArray(userServer.listUser(), User.class));
        return s;
    }
}
