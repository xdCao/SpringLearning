package chapter5;

import chapter3.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xdcao on 2017/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SimpleTest {


    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        ((ClassPathXmlApplicationContext)ctx).destroy();
    }

}
