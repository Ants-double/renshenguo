package com.antsdouble.factory.abstractfactory;

import com.antsdouble.factory.Cpu;
import com.antsdouble.factory.Mainboard;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/21
 */
public interface AbstractFactory {
    /**
     * @return code.factorydemo.Cpu
     * @Author ants_double
     * @Description 创建CPU工厂
     * @Date 2018-12-15 21:31
     * @Param []
     **/
    public Cpu createCpu();

    /*
     * @Author ants_double
     * @Description 创建主板工厂
     * @Date 2018-12-15 21:31
     * @Param []
     * @return code.factorydemo.Mainboard
     **/
    public Mainboard createMainboard();
}