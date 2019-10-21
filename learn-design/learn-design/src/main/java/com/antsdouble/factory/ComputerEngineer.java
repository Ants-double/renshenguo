package com.antsdouble.factory;

/**
 * @Auther: ants_double
 * @Date: 2018-12-15 21:15
 * @Description:
 */
public class ComputerEngineer {
    private  Cpu cpu=null;
    private  Mainboard mainboard=null;
    public void makeComputer(int cpuType,int mainboard){
        preparHardwares(cpuType,mainboard);
    }

    private void preparHardwares(int cpuType, int mainboard) {
        this.cpu=CpuFactory.createCpu(cpuType);
        this.mainboard=MainboardFactory.createMainboard(mainboard);
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
