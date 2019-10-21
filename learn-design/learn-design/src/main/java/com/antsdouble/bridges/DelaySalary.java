package com.antsdouble.bridges;

/**
 * @ClassName DelaySalary
 * @Description 晚发工资
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public class DelaySalary extends SalaryAbstract {
    public DelaySalary(PayOffInterface payOff) {
        super(payOff);
    }

    public void sendSalary(){
        super.sendSalary();
        System.out.println("操，这个月又要晚发工资了");
    }
}
