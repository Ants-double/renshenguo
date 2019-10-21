package com.antsdouble.builder;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/21
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
