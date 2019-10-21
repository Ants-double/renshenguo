package code.code.threaddemo;

import java.util.concurrent.Callable;

/**
 * @Auther: ants_double
 * @Date: 2018-12-24 21:43
 * @Description:
 */
public class TaskWithResult implements Callable<String> {

    private  int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult"+id;
    }



}
