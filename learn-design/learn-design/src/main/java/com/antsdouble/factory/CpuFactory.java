package com.antsdouble.factory;

import java.lang.annotation.ElementType;

/**
 * @Auther: ants_double
 * @Date: 2018-12-15 21:11
 * @Description:
 */
public class CpuFactory {
    public static Cpu createCpu(int type) {
        Cpu cpu = null;
        if (type == 1) {
            cpu = new IntelCpu(755);

        } else if (type == 2) {
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}
