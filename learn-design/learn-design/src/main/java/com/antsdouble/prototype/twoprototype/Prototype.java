package com.antsdouble.prototype.twoprototype;

public interface Prototype {
    public Prototype clone();

    public String getName();

    public void setName(String name);
}
