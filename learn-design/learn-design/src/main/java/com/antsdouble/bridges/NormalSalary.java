package com.antsdouble.bridges;

/**
 * @ClassName NormalSalary
 * @Description 正常发工资了
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public class NormalSalary extends SalaryAbstract {
    public NormalSalary(PayOffInterface payOff) {
        super(payOff);
    }

    public  void  sendSalary(){
        super.sendSalary();
        System.out.println("正常发工资！");
    }
}
