package com.smartatone.BeanFactoryPostProcessPractice.v1_simpleProperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 修改简单属性的值
 * simpleProperty初始值是java
 * 经过处理以后变成了new java
 */
public class ActiveMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/beanFactoryPostProcessPractice/v1_simpleProperty/v1.xml");
        SimplePropertyDTO simplePropertyDTO = applicationContext.getBean(SimplePropertyDTO.class);
        System.out.println(simplePropertyDTO.getName());
    }
}
