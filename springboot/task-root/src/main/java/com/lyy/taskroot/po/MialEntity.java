package com.lyy.taskroot.po;

import java.io.Serializable;

/**
 * @author lyy
 * @description
 * @date 2019/4/29
 */
public class MialEntity implements Serializable {
    private static final long serialVersionUID = -2855451275380423334L;

    private  String eMail;
    private  String id;

    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
