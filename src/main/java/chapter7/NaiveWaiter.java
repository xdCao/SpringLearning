package chapter7;

/**
 * Created by xdcao on 2017/4/17.
 */
public class NaiveWaiter implements Waiter{
    @Override
    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving "+name+"...");
    }
}
