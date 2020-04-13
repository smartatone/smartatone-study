package com.smartatone.BeanFactoryPostProcessPractice.v3_completeBeanProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("BeanPostProcessor construct()!!");
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
        System.out.println("BeanPostProcessor postProcessAfterInitialization() into");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
        System.out.println("BeanPostProcessor postProcessBeforeInitialization() into");
        return arg0;
    }
}
