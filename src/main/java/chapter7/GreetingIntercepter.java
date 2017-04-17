package chapter7;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by xdcao on 2017/4/17.
 */
public class GreetingIntercepter implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args=invocation.getArguments();
        String clientName= (String) args[0];
        System.out.println("ha ha ha ");
        Object obj=invocation.proceed();
        System.out.println("hi hih i");
        return obj;
    }
}
