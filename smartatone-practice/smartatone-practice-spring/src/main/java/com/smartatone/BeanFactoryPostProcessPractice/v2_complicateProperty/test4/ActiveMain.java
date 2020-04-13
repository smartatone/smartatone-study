package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.test4;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.ConsumerBean;

/**
 * @author xuyang001
 **/
public class ActiveMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/beanFactoryPostProcessPractice/v2_complicateProperty/v2-test4.xml");
        ConsumerBean consumerBean = applicationContext.getBean(ConsumerBean.class);
        System.out.println("consumerBean name=" + consumerBean.getProperties().getProperty("name"));
        Properties properties = (Properties) applicationContext.getBean("myProperties");
        System.out.println("properties name=" + properties.getProperty("name"));
    }
}
