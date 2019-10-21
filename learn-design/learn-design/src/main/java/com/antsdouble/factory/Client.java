package com.antsdouble.factory;

/**
 * @Auther: ants_double
 * @Date: 2018-12-15 21:23
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        ComputerEngineer cf=new ComputerEngineer();
        cf.makeComputer(1,1);
    }
}
