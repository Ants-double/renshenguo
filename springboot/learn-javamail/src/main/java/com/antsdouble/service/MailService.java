package com.antsdouble.service;

import com.antsdouble.beans.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("mailService")
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    //简单的发送文字
    public void sendMail() {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mailProperties.getFrom());

        message.setTo(mailProperties.getTo());

        message.setSubject("it is a test for spring boot");

        message.setText("你好，我是ly，我正在测试发送邮件。");


        try {
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //带附件的
    public void sendMailAttachFile() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(mailProperties.getFrom());

        helper.setTo(mailProperties.getTo());

        helper.setSubject("主题：发送有附件的邮件");

        helper.setText("你好，我是ly，我正在测试发送一封有附件的邮件。");
        FileSystemResource file1 = new FileSystemResource(new File("E:\\01.gif"));

        FileSystemResource file2 = new FileSystemResource(new File("E:\\02.png"));

        helper.addAttachment("附件-1.jpg", file1);

        helper.addAttachment("附件-2.jpg", file2);
        try {
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //嵌入附件的
    public void sendMailAddContent() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);


        helper.setFrom(mailProperties.getFrom());

        helper.setTo(mailProperties.getTo());


        helper.setSubject("主题：嵌入静态资源");

        helper.setText("<html><body><img src=\"cid:hello\" ></body></html>", true);


        // 注意addInline()中资源名称 hello 必须与 text正文中cid:hello对应起来

        FileSystemResource file1 = new FileSystemResource(new File("d:\\cat.jpg"));

        helper.addInline("hello", file1);

        try {
            mailSender.send(mimeMessage);

        } catch (Exception e) {


        }
    }


}
