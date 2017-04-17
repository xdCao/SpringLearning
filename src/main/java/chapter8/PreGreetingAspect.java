package chapter8;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by xdcao on 2017/4/17.
 */
@Aspect
public class PreGreetingAspect {

    @Before("execution(* greetTo(..))")
    public void beforeGreeting(){
        System.out.println("How are you");
    }

}
