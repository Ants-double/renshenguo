package code.eventdemo;

import java.util.EventListener;

/**
 * @Auther: ants_double
 * @Date: 2018-12-25 22:07
 * @Description:
 */
public class StateChangeListener implements EventListener {
    public void handleEvent(MyEvent event){
        System.out.println("change begin...");
        System.out.println("statue"+event.getSourceState());
        System.out.println("-------------");
    }
}
