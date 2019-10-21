package com.antsdouble.prototype;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 10:42
 * @Description:
 */
public class ConcretePrototype2 implements Prototype {
    @Override
    public Prototype clone() {
        return new ConcretePrototype2();
    }
}
