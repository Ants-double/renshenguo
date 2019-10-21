package com.antsdouble.states;

/**
 * @ClassName WorkHard
 * @Description 超额工作
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class WorkHard implements WorkState {
    private WorkContext workContext;

    public WorkHard(WorkContext workContext) {
        this.workContext = workContext;
    }

    public void work() {
        System.out.println("听说要发前年的年终奖了，要好好工作，挣取多发点钱");
    }
}
