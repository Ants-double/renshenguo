package code.eventdemo;


import java.util.EventObject;

/**
 * @Auther: ants_double
 * @Date: 2018-12-25 21:56
 * @Description:
 */
public class MyEvent extends EventObject {
    private static final  long serialVersionUID=1l;
    private int sourceState;
    public MyEvent(Object source){
        super(source);
        sourceState=((Source)source).getFlag();
    }

    public  int getSourceState(){
        return sourceState;
    }
}
