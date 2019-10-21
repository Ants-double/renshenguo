package com.antsdouble.factory.abstractfactory;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/21
 */
public class Client {

    public static void main(String[] args) {
        ComputerEngineer cf=new ComputerEngineer();
        AbstractFactory af=new IntelFactory();
        cf.makeComputer(af);
        AbstractFactory tf=new AmdFactory();
        cf.makeComputer(tf);
    }
}
