package com.antsdouble.states;

/**
 * @ClassName WorkNegative
 * @Description 消极工作
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class WorkNegative implements WorkState {

    private  WorkContext workContext;

    public WorkNegative(WorkContext workContext) {
        this.workContext = workContext;
    }

    public void work() {
        System.out.println("日了个狗，工资拖了两个月没有发了。让人如何积极工作");
    }
}
