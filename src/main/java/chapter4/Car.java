package chapter4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by xdcao on 2017/4/10.
 */
@Scope("prototype")
@Component
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用构造函数");
    }

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("调用setter方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
        System.out.println("调用beanfactory方法");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName=name;
        System.out.println("调用BeannameAware方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet方法");
    }


    public void myInit(){
        this.maxSpeed=240;
        System.out.println("调用自定义的初始化方法");
    }


    public void myDestroy(){
        System.out.println("调用自定义的destroy方法");
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
