package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.test4;

import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;

import com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.ConsumerBean;

public class MyConsumerBean extends ConsumerBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        Properties defaultProperties = new Properties();
        defaultProperties.put("name", "new java");
        Properties newDefaultProperties = new Properties(defaultProperties);
        setProperties(newDefaultProperties);
    }
}
