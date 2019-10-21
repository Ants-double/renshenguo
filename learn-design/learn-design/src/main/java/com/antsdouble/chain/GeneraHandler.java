package com.antsdouble.chain;

/**
 * @ClassName GeneraHandler
 * @Description 总经理
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class GeneraHandler implements Handler {
    private Handler handler;

    public void handleRequest(Double number) {
        if (number < 5) {
            System.out.println("总经理给你报了，你以后少花点啊");
        } else {
            System.out.println("你花超了，自费吧，不能报");
        }
    }

    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
