package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.test2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class PersonBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("******processor start...");
        String[] beanStr = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanStr) {
            if ("person".equals(beanName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                System.out.println("******processor修改name");
                beanDefinition.getPropertyValues().add("name", "processor");
            }
        }
        System.out.println("******processor end");
    }
}
