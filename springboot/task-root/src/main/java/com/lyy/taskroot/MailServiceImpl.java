package com.lyy.taskroot;

import com.github.pagehelper.Page;
import com.lyy.taskroot.mapper.MailMapper;
import com.lyy.taskroot.po.MailDto;
import com.lyy.taskroot.po.MailSendProperties;
import com.lyy.taskroot.po.MialEntity;
import com.lyy.taskroot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lyy
 * @description
 * @date 2019/4/29
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    MailMapper mailMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailSendProperties mailSendProperties;


    @Override
    public List<MailDto> selectNoDailyUser() {
        List<MailDto> mailDtos = new ArrayList<>();
        List<MialEntity> mialEntityList = mailMapper.selectNoDailyUser();
        StringBuffer stringBuffer = new StringBuffer();
        if (mialEntityList.size() > 0) {
            for (MialEntity item : mialEntityList) {
                System.out.println("准备发送" + item.getUserName() + "的提醒邮件");
                stringBuffer.append(item.getUserName());
                stringBuffer.append(",");
                MailDto mailDto = new MailDto();
                mailDto.setMailSubject(mailSendProperties.getSubject());
                mailDto.setMailContent(mailSendProperties.getContent());
                mailDto.setMailTo(item.geteMail());
                mailDto.setMailFrom(mailSendProperties.getFrom());
                mailDtos.add(mailDto);
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String localTime = LocalDateTime.now().format(formatter);
            MailDto mailALLDto = new MailDto();
            mailALLDto.setMailSubject(localTime + "日报统计邮件");
            mailALLDto.setMailContent(localTime + "一共有" + mialEntityList.size() + "人没有提交日报，人名如下:" + stringBuffer.toString());
            mailALLDto.setMailTo("guojingwei@everisetech.com");
            mailALLDto.setMailFrom(mailSendProperties.getFrom());
            mailDtos.add(mailALLDto);
            MailDto mailAssistantDto = new MailDto();
            mailAssistantDto.setMailSubject(localTime + "日报统计邮件");
            mailALLDto.setMailContent(localTime + "一共有" + mialEntityList.size() + "人没有提交日报，人名如下:" + stringBuffer.toString());
            mailAssistantDto.setMailTo("tanghaiying@everisetech.com");
            mailAssistantDto.setMailFrom(mailSendProperties.getFrom());
            mailDtos.add(mailAssistantDto);
            System.out.println("准备发送汇总的提醒邮件");


        }

        return mailDtos;
    }

    @Override
    public Page<MailDto> getUserList() {
        Page<MailDto> mailDtos = new Page<>();
        Page<MialEntity> userList = mailMapper.getUserList();
        if (userList.size() > 0) {
            for (MialEntity item : userList) {
                MailDto mailDto = new MailDto();
                mailDto.setMailSubject(mailSendProperties.getSubject());
                mailDto.setMailContent(mailSendProperties.getContent());
                mailDto.setMailTo(item.geteMail());
                mailDto.setMailFrom(mailSendProperties.getFrom());
                mailDtos.add(mailDto);
            }
        }
        return mailDtos;
    }

    @Override
    public void sendMail(List<MailDto> mailDtos) {

        for (MailDto item : mailDtos) {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(item.getMailFrom());

            message.setTo(item.getMailTo());

            message.setSubject(item.getMailSubject());

            message.setText(item.getMailContent());

            try {
                mailSender.send(message);
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @Override
    public void sendMailAttachFile(List<MailDto> mailDtos) {
        for (MailDto item : mailDtos) {
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = null;

                helper = new MimeMessageHelper(mimeMessage, true);

                helper.setFrom(item.getMailFrom());

                helper.setTo(item.getMailTo());

                helper.setSubject(item.getMailSubject());

                helper.setText(item.getMailContent());
                FileSystemResource file1 = new FileSystemResource(new File("E:\\01.gif"));

                FileSystemResource file2 = new FileSystemResource(new File("E:\\02.png"));

                helper.addAttachment("附件-1.jpg", file1);

                helper.addAttachment("附件-2.jpg", file2);

                mailSender.send(mimeMessage);

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 功能描述 开始检测任务
     *
     * @param []
     * @return java.lang.Boolean
     * @author lyy
     * @date 2019/4/30
     */
    public Boolean startMailTask() {
        Boolean taskStart = false;

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("发送邮件");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                String request = HolidayUtil.request(LocalDateTime.now().format(formatter));
                if ("0".equals(request) || "2".equals(request) || LocalDateTime.now().format(formatter).equals("20190505")) {
                    System.out.println("今天要工作:" + LocalDateTime.now().format(formatter));
                    sendMail(selectNoDailyUser());
                } else {
                    System.out.println("今天是休息日:" + LocalDateTime.now().format(formatter));

                }
            }
        }, 9, 24, TimeUnit.HOURS);


        return taskStart;
    }

}
