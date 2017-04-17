package chapter7;

/**
 * Created by xdcao on 2017/4/14.
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecord=new ThreadLocal<MethodPerformance>();

    public static void begin(String method){
        System.out.println("begin monitor...");
        MethodPerformance mp=new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        MethodPerformance mp=performanceRecord.get();
        mp.printPerformance();;
    }

}
