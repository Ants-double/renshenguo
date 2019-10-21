package com.antsdouble.decorator;

/**
 * @ClassName DelayDecorator
 * @Description 晚发
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class DelayDecorator extends AbstractDecorator {

    public DelayDecorator(Boss boss) {
        super(boss);
    }
    private  void  delaySalary(){
        System.out.println("肯定发的，你们要相信老板，只是会晚发工资！");
    }

    @Override
    public void payOffSalary() {
        super.payOffSalary();
        delaySalary();
    }
}
