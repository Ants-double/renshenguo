package com.lyy.taskroot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRootApplicationTests {
    @Autowired
    MailServiceImpl mailService;

    @Test
    public void contextLoads() {
        System.out.println(mailService.selectNoDailyUser());
    }


    @Test
    public void checkCalendar(){
        System.out.println(mailService.startMailTask());
    }

}
