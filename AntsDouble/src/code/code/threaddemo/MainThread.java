package code.code.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: ants_double
 * @Date: 2018-12-24 20:59
 * @Description:
 */
public class MainThread {
    //    public static void main(String[] args) {
//        LiftOff launch=new LiftOff();
//        launch.run();
//    }
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
