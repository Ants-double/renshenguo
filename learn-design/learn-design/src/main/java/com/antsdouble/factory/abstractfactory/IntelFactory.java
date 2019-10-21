package com.antsdouble.factory.abstractfactory;

import com.antsdouble.factory.Cpu;
import com.antsdouble.factory.IntelCpu;
import com.antsdouble.factory.IntelMainboard;
import com.antsdouble.factory.Mainboard;
import com.antsdouble.factory.abstractfactory.AbstractFactory;

public class IntelFactory implements AbstractFactory {

    public Cpu createCpu() {
        return new IntelCpu(755);
    }


    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
}
