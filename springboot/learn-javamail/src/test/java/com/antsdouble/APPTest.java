package com.antsdouble;

import com.antsdouble.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class APPTest {
    @Autowired
    MailService mailService;

    @Test
    public void sendMail() {
       // mailService.sendMail();

        try {
            mailService.sendMailAttachFile();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
