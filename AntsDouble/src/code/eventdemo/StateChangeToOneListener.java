package code.eventdemo;

import javax.xml.transform.Source;
import java.util.EventListener;

/**
 * @Auther: ants_double
 * @Date: 2018-12-25 22:10
 * @Description:
 */
public class StateChangeToOneListener implements EventListener {
    public void handleEvent(MyEvent event){
        System.out.println("change 1 ..");
        System.out.println("statue"+event.getSourceState());
        System.out.println("=====================");
    }
}
