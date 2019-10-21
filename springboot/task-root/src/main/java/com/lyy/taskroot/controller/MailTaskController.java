package com.lyy.taskroot.controller;

import com.lyy.taskroot.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lyy
 * @description
 * @date 2019/4/29
 */
@Controller
@RequestMapping("/task")
public class MailTaskController {

    @Autowired
    MailServiceImpl mailService;

    @RequestMapping(value = "dailyTask", method = RequestMethod.GET)
    @ResponseBody
    public String helloTask() {
        try {
            mailService.startMailTask();
            return "这是一个日报任务:ok";
        } catch (Exception e) {
            return "这是一个日报任务:error";
        }
    }
}
