package code.eventdemo;

/**
 * @Auther: ants_double
 * @Date: 2018-12-25 22:20
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Source source=new Source();
        //source.addStateChangeListener(new StateChangeListener());
        source.addStateChangeToOneListener(new StateChangeToOneListener());
        source.changeFlag();
        source.changeFlag();
        source.changeFlag();

    }
}
