package com.lyy.taskroot.po;

import java.io.Serializable;

/**
 * @author lyy
 * @description
 * @date 2019/4/29
 */
public class MailPo implements Serializable {
    private static final long serialVersionUID = 1801290508999321007L;

    private String id;
    private String userName;
    private String eMail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
