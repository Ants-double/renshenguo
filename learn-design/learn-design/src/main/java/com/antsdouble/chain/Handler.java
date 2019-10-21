package com.antsdouble.chain;

public interface Handler {
    void handleRequest(Double number);

    void setNextHandler(Handler handler);
}
