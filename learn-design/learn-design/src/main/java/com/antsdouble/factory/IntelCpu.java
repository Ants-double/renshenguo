package com.antsdouble.factory;

/**
 * @Auther: ants_double
 * @Date: 2018-12-15 20:55
 * @Description:
 */
public class IntelCpu implements Cpu {

    /**
     * cpu的针脚数
     **/
    private int pins = 0;

    /**
     * @Author ants_double
     * @Description 
     * @Date 2018-12-15 20:58
     * @Param [pins]
     * @return 
     **/
    public IntelCpu(int pins){
        this.pins=pins;
    }
    @Override
    public void calculate() {

        System.out.println("Intel cpu的针脚数"+pins);
    }
}
