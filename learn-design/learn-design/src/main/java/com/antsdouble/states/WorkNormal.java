package com.antsdouble.states;

/**
 * @ClassName WorkNormal
 * @Description 正常工作
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class WorkNormal implements WorkState {
    private WorkContext workContext;

    public WorkNormal(WorkContext workContext) {
        this.workContext = workContext;
    }

    public void work() {
        System.out.println("老板通知这个月正常发工资，不用担心工资，认真工作吧");
    }
}
