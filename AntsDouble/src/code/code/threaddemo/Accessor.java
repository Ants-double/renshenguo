package code.code.threaddemo;

/**
 * @Auther: ants_double
 * @Date: 2018-12-25 22:40
 * @Description:
 */
public class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn) {
        id = idn;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "Accessor{" +
                "id=" + id +ThreadLocalVariableHolder.get()+
                '}';
    }
}
