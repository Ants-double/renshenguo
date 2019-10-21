package com.antsdouble.chain;

/**
 * @ClassName DeptHandler
 * @Description 部门
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class DeptHandler implements Handler {
    private Handler handler=null;
    public void handleRequest(Double number) {
        if (number<1.5){
            System.out.println("嗯，部门给你报了");
        }
        else {
            System.out.println("太多了，我给你上报");
            this.handler.handleRequest(number);
        }
    }

    public void setNextHandler(Handler handler) {
this.handler=handler;
    }
}
