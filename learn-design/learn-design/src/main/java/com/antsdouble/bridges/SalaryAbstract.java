package com.antsdouble.bridges;

/**
 * @ClassName SalaryAbstract
 * @Description 抽象工资类
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public abstract class SalaryAbstract {
    PayOffInterface payOff;

    public SalaryAbstract(PayOffInterface payOff) {
        this.payOff = payOff;
    }
    public void sendSalary(){
        this.payOff.sendMoney();
    }
}
