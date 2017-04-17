package chapter8;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by xdcao on 2017/4/17.
 */
@Aspect
public class TestAspect {

    @Around("execution(* greetTo(..))")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("------joinPointAccess-----");
        System.out.println("args[0]:"+pjp.getArgs()[0]);
        System.out.println("signature:"+pjp.getTarget().getClass());
        pjp.proceed();
        System.out.println("------joinPointAccess-----");
    }
}
