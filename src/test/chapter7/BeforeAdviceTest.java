package chapter7;

import chapter3.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xdcao on 2017/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BeforeAdviceTest {

    @Test
    public void before(){
        Waiter target=new NaiveWaiter();
        BeforeAdvice advice=new GreetingBeforeAdvice();
        ProxyFactory pf=new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(advice);
        Waiter proxy=(Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }


    @Test
    public void testSpringConfigAop(){
        String path="bean.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter=(Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
    }

    @Test
    public void testAdvisor(){
        String path="bean.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        cWaiter waiter= (cWaiter) ctx.getBean("waiter");
        cSeller seller=(cSeller) ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }


}
