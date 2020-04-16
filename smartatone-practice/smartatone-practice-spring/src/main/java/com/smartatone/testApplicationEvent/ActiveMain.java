package com.smartatone.testApplicationEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActiveMain {

    public static void main(String[] args) {
        //这里没有注解，所以从上下文里获取
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/testApplicationEvent/v1.xml");

        MyEventPublisherAware myEventPublisherAware = (MyEventPublisherAware) applicationContext
                .getBean("myEventPublisherAware");
        myEventPublisherAware.test("1");
        myEventPublisherAware.test("2");
        myEventPublisherAware.test("3");

    }
}
