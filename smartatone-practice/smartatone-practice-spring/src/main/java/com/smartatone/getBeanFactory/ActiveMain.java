package com.smartatone.getBeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActiveMain {

    public static void main(String[] args) {
        //这里没有注解，所以从上下文里获取
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/getBeanFactory/v1.xml");
        Person person = null;

        BeanFactoryAware_BeanUtils beanUtils1 = (BeanFactoryAware_BeanUtils) applicationContext.getBean("beanUtils1");
        person = beanUtils1.getBean(Person.class);
        System.out.println(person.getName());
        person = null;

        ApplicationContextAware_BeanUtils beanUtils2 = (ApplicationContextAware_BeanUtils) applicationContext
                .getBean("beanUtils2");
        person = beanUtils2.getBean(Person.class);
        System.out.println(person.getName());
        person = null;

        ApplicationListener_BeanUtils beanUtils3 = (ApplicationListener_BeanUtils) applicationContext
                .getBean("beanUtils3");
        person = beanUtils3.getBean(Person.class);
        System.out.println(person.getName());
    }
}
