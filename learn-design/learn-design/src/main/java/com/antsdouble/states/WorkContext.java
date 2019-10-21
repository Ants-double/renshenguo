package com.antsdouble.states;

/**
 * @ClassName WorkContext
 * @Description 环境类，作为外部调用的接口，负责切换不同的状态
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class WorkContext {

    private WorkNormal workNormal;
    private WorkNegative workNegative;
    private WorkHard workHard;
    private Integer money;

    public WorkContext() {
        this.workNormal = new WorkNormal(this);
        this.workNegative = new WorkNegative(this);
        this.workHard = new WorkHard(this);

    }



    public void getWorkState(Integer number) {
        this.money=number;
        if (money>0){
            workHard.work();
        }
        else if (money==0)
        {
            workNormal.work();
        }
        else
        {
            workNegative.work();
        }

    }

}
