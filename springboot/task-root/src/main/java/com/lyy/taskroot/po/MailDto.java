package com.lyy.taskroot.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author lyy
 * @description
 * @date 2019/4/29
 */

public class MailDto implements Serializable {
    private static final long serialVersionUID = 3052282306149074161L;
    //主题
    private String mailSubject;


    private String mailFrom;

    //发送的地址
    private String mailTo;
    //内容
    private String mailContent;

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    @Override
    public String toString() {
        return "MailDto{" +
                "mailSubject='" + mailSubject + '\'' +
                ", mailFrom='" + mailFrom + '\'' +
                ", mailTo='" + mailTo + '\'' +
                ", mailContent='" + mailContent + '\'' +
                '}';
    }
}
