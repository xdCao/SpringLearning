package chapter8;

import chapter3.Application;
import chapter7.Waiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.crypto.KeySelectorResult;

/**
 * Created by xdcao on 2017/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AspectJTest {

    @Test
    public void test1(){
        String path="bean.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter=(Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
        Seller seller=(Seller)waiter;
        seller.sell("1ww");
    }


    @Test
    public void test2(){
        String path="bean.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter=(Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
    }


}
