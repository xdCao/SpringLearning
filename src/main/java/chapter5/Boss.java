package chapter5;

import chapter4.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by xdcao on 2017/4/13.
 */
@Component
public class Boss {

    private Car car;

    public Boss(){
        System.out.println("调用构造器");
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @PostConstruct
    private void init1(){
        System.out.println("init1");
    }

    @PostConstruct
    private void init2(){
        System.out.println("init2");
    }

    @PreDestroy
    private void destroy1(){
        System.out.println("destroy1");
    }

    @PreDestroy
    private void destroy2(){
        System.out.println("destroy2");
    }

}
