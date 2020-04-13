package com.smartatone.BeanFactoryPostProcessPractice.v3_completeBeanProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("BeanFactoryPostProcessor constructor()！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
        System.out.println("BeanFactoryPostProcessor postProcessBeanFactory() into!");
        BeanDefinition bd = arg0.getBeanDefinition("person");
        bd.getPropertyValues().addPropertyValue("phone", "110");
        System.out.println("BeanFactoryPostProcessor postProcessBeanFactory() out!");
    }
}
