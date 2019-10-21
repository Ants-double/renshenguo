package com.antsdouble.factory.abstractfactory;

import com.antsdouble.factory.AmdCpu;
import com.antsdouble.factory.AmdMainboard;
import com.antsdouble.factory.Cpu;
import com.antsdouble.factory.Mainboard;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/21
 */
public class AmdFactory implements AbstractFactory{
    public Cpu createCpu() {

            return new AmdCpu(938);
    }

    public Mainboard createMainboard() {
            return new AmdMainboard(938);
    }
}
