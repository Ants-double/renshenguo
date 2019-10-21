package com.antsdouble.learnsession.pv;

import java.io.Serializable;

/**
 * @author lyy
 * @description
 * @date 2019/5/14
 */
public class User implements Serializable {

    private static final long serialVersionUID = 9172776733807051390L;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
