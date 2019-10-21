package com.antsdouble.decorator;

/**
 * @ClassName MyBoss
 * @Description myboss
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class MyBoss implements Boss {
    public void payOffSalary() {
        System.out.println("老板应该发工资");
    }
}
