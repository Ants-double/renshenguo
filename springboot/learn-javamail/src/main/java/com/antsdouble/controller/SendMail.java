package com.antsdouble.controller;
import com.antsdouble.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mail")
public class SendMail  {

    @Autowired
    MailService mailService;
    @RequestMapping(value = {"/sendSimple"},method = RequestMethod.GET)
    public void sendMail(){
        mailService.sendMail();
    }
}
