package chapter7;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by xdcao on 2017/4/17.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String clientName=(String) args[0];
        System.out.println("How are you! Mr."+clientName+".");
    }
}
