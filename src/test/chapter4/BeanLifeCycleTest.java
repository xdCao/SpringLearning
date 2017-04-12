package chapter4;

import chapter3.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xdcao on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BeanLifeCycleTest {

    @Test
    public void test(){
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory beanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader((DefaultListableBeanFactory)beanFactory);
        reader.loadBeanDefinitions(resource);
        ((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyInstaniationAwareBeanPostProcessor());
        Car car1=(Car)beanFactory.getBean("car");
        car1.setColor("红色");
        Car car2=(Car)beanFactory.getBean("car");
        System.out.println("car1 === car2:"+(car1==car2));
        ((DefaultListableBeanFactory)beanFactory).destroySingletons();
    }

    @Test
    public void testApplicationContext(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        Car car=applicationContext.getBean("car",Car.class);

    }


}
