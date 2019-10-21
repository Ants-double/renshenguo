package com.antsdouble.builder;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/21
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}
