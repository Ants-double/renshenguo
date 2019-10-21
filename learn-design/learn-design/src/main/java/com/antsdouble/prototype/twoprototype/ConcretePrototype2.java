package com.antsdouble.prototype.twoprototype;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 11:00
 * @Description:
 */
public class ConcretePrototype2 implements Prototype {
    private String name;

    @Override
    public String toString() {
        return "ConcretePrototype2{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Prototype clone() {
        ConcretePrototype2 prototype = new ConcretePrototype2();
        prototype.setName(this.name);
        return prototype;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
