package chapter6;

import chapter3.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xdcao on 2017/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class EventTest {

    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        MailSender mailSender=(MailSender)ctx.getBean("mailSender");
        mailSender.sendMail("aaa@bb.com");
    }

}
