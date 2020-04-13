package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.test3;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.ConsumerBean;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("consumerBean".equals(beanName)) {
            ConsumerBean consumerBean = (ConsumerBean) bean;
            Properties defaultProperties = new Properties();
            defaultProperties.put("name", "new java");
            Properties newDefaultProperties = new Properties(defaultProperties);
            consumerBean.setProperties(newDefaultProperties);
        }
        return bean;
    }

}
