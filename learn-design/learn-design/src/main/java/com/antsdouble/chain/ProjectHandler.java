package com.antsdouble.chain;

/**
 * @ClassName ProjectHandler
 * @Description 项目经理
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class ProjectHandler implements Handler {
    private Handler handler = null;

    public void handleRequest(Double number) {
        if (number > 0 && number < 1) {
            System.out.println("小于一块钱，项目经理给你报了，找财务领赏吧。");

        } else {
            System.out.println("太多了，我给你上报");
            this.handler.handleRequest(number);
        }
    }

    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
