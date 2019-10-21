package com.antsdouble.facade;

/**
 * @ClassName Facade
 * @Description 外观
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class Facade {
    private  Attendance attendance;
    private Performance performance;
    private WipeOut wipeOut;

    //最好是一个单例类
    public Facade() {
        this.attendance = new Attendance();
        this.performance = new Performance();
        this.wipeOut = new WipeOut();
    }

    public void money(){
        this.attendance.calculation();
        this.performance.calculation();
        this.wipeOut.calculation();
        System.out.println("只是计算工资，不要添加其它功能");
    }
}
