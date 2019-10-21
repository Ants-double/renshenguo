package com.antsdouble.factory;

/**
 * @Auther: ants_double
 * @Date: 2018-12-15 21:00
 * @Description:
 */
public class AmdCpu implements Cpu {
    private  int pins=0;
    public AmdCpu (int pins){
        this.pins=pins;
    }
    @Override
    public void calculate() {
        System.out.println("AMD cpu的针脚数"+pins);
    }
}
