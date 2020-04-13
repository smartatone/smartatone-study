package com.smartatone.BeanFactoryPostProcessPractice.v3_completeBeanProcess;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("InstantiationAwareBeanPostProcessorAdapter constructor()！");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter postProcessBeforeInstantiation() into!");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter postProcessAfterInstantiation() into!");
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName)
            throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter postProcessPropertyValues() into!");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter postProcessBeforeInitialization() into!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessorAdapter postProcessAfterInitialization() into!");
        return bean;
    }
}
