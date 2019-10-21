package com.antsdouble.bridges;

/**
 * @ClassName AdvanceSalary
 * @Description 提前发
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public class AdvanceSalary extends SalaryAbstract {
    public AdvanceSalary(PayOffInterface payOff) {
        super(payOff);
    }

    public void  sendSalary(){
        super.sendSalary();
        System.out.println("这是提前发的，怎么可以，别做梦了");
    }
}
