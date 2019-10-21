package com.antsdouble.prototype.twoprototype;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 10:54
 * @Description:
 */
public class ConcretePrototype1 implements Prototype {
    private String name;

    @Override
    public String toString() {
        return "ConcretePrototype1{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Prototype clone() {
        ConcretePrototype1 prototype = new ConcretePrototype1();
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
