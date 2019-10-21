package com.antsdouble.factory;

/**
 * @Auther: ants_double
 * @Date: 2018-12-15 21:08
 * @Description:
 */
public class AmdMainboard implements Mainboard {
    private  int cpuHoles=0;
    public AmdMainboard(int cpuHoles){
        this.cpuHoles=cpuHoles;
    }
    @Override
    public void installCPU() {
        System.out.println("AMD的cpu的插槽孔数是："+cpuHoles);
    }
}
