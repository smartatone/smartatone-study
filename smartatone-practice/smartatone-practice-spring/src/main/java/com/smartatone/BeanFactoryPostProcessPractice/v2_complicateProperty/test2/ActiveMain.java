package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuyang001
 **/
public class ActiveMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/beanFactoryPostProcessPractice/v2_complicateProperty/v2-test2.xml");
        applicationContext.getBean(Person.class).sayName();
    }
}
