package com.antsdouble.decorator;

/**
 * @ClassName AbstractDecorator
 * @Description 抽象装饰者
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class AbstractDecorator implements Boss {
    private Boss boss;

    public AbstractDecorator(Boss boss) {
        this.boss = boss;
    }

    public void payOffSalary() {
        this.boss.payOffSalary();
    }
}
