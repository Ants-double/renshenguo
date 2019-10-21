package com.antsdouble.prototype;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 10:41
 * @Description:
 */
public class ConcretePrototype1 implements Prototype {

    @Override
    public Prototype clone() {
        return new ConcretePrototype1();
    }
}
