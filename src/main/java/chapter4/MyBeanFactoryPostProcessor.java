package chapter4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by xdcao on 2017/4/11.
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd=beanFactory.getBeanDefinition("car");
        bd.getPropertyValues().addPropertyValue("brand","奇瑞QQ");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory");
    }
}
