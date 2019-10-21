package com.antsdouble.builder;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/21
 */
public class ConcreteBuilder implements Builder {
    private Product product = new Product();


    public void buildPart1() {
        product.setPart1("编号：9527");
    }


    public void buildPart2() {
        product.setPart2("名称：test");
    }


    public Product retrieveResult() {
        return product;
    }
}
