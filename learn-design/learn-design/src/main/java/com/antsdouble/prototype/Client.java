package com.antsdouble.prototype;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 10:50
 * @Description:
 */
public class Client {
    private Prototype prototyp;

    public Client(Prototype prototyp) {
        this.prototyp = prototyp;
    }

    public void operation(Prototype example) {
        Prototype copyPrototype =(Prototype) example.clone();
    }
}
