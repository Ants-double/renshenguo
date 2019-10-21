package com.antsdouble.prototype.twoprototype;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 11:08
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        try {
            Prototype p1 = new ConcretePrototype1();
            PrototypeManager.setPrototype("p1", p1);
            Prototype p3 = PrototypeManager.getPrototype("p1").clone();
            p3.setName("zhang san");
            System.out.println("first instance " + p3);

            Prototype p2 = new ConcretePrototype2();
            PrototypeManager.setPrototype("p1", p2);

            Prototype p4 = PrototypeManager.getPrototype("p1").clone();
            p4.setName("li si");
            System.out.println("second instance " + p4);
            Prototype p41 = PrototypeManager.getPrototype("p1").clone();
            p41.setName("li si 4");
            System.out.println("second instance " + p41);
            PrototypeManager.removePrototype("p1");
            Prototype p5 = PrototypeManager.getPrototype("p1").clone();
            p5.setName("wang wu");
            System.out.println("three instance " + p5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
