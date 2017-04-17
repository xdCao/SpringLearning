package chapter8;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by xdcao on 2017/4/17.
 */
public class NamePointCut {

    @Pointcut("within(chapter7.*)")
    private void inPackage(){}

    @Pointcut("execution(* greetTo(..))")
    protected void greetTo(){}

    @Pointcut(value = "inPackage() && greetTo()")
    public void inPkgGreetTo(){}

}
