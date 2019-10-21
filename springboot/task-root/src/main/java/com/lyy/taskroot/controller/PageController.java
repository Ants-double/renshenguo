package com.lyy.taskroot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyy.taskroot.MailServiceImpl;
import com.lyy.taskroot.po.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyy
 * @description
 * @date 2019/5/5
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    MailServiceImpl mailService;

    @RequestMapping(value = {"/test"},method = RequestMethod.GET)
    public Page<MailDto> getUserList(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<MailDto> userList = mailService.getUserList();
        return  userList;
    }
}
