package com.smartatone.BeanFactoryPostProcessPractice.v4_completeBeanProcess_getBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("BeanFactoryPostProcessor constructor()！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor postProcessBeanFactory() into!");
        String[] beanStr = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanStr) {
            if ("person".equals(beanName)) {
                beanFactory.getBean(beanName);
            }
        }
        System.out.println("BeanFactoryPostProcessor postProcessBeanFactory() out!");
    }
}
