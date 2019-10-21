package com.antsdouble.factory.abstractfactory;

import com.antsdouble.factory.Cpu;
import com.antsdouble.factory.Mainboard;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/21
 */
public class ComputerEngineer {
    private Cpu cpu=null;
    private Mainboard mainboard=null;
    public  void makeComputer(AbstractFactory af){
        prepareHardwares(af);
    }

    private void prepareHardwares(AbstractFactory af) {
        this.cpu=af.createCpu();
        this.mainboard=af.createMainboard();
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
