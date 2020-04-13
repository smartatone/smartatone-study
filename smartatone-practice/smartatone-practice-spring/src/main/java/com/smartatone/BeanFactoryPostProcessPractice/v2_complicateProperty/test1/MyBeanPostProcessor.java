package com.smartatone.BeanFactoryPostProcessPractice.v2_complicateProperty.test1;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanStr = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanStr) {
            /**
             * 1.直接new新的对象注入容器中
             * 执行结果:
             *  createConsumer start,properties name=new java
             *  consumerBean name=new java
             *  properties name=new java
             */
            //            if ("myProperties".equals(beanName)) {
            //                Properties defaultProperties = new Properties();
            //                defaultProperties.put("name", "new java");
            //                Properties newDefaultProperties = new Properties(defaultProperties);
            //                //重新注入到spring容器
            //                beanFactory.registerSingleton(beanName, newDefaultProperties);
            //            }
            /**
             * 2.获取到property，然后替换
             * 执行结果：
             *  报错:Could not register object [{}] under bean name 'myProperties': there is already object [{}] bound
             */
            //            if ("myProperties".equals(beanName)) {
            //                Properties originalProperties = (Properties) beanFactory.getBean(beanName);
            //                if (originalProperties != null) {
            //                    Properties defaultProperties = new Properties();
            //                    defaultProperties.put("name", "new java");
            //                    Properties newDefaultProperties = new Properties(defaultProperties);
            //                    //重新注入到spring容器
            //                    beanFactory.registerSingleton(beanName, newDefaultProperties);
            //                }
            //            }
            /**
             * 3
             * 执行结果:
             *  createConsumer start,properties name=java
             *  consumerBean name=new java
             *  properties name=java
             */
            //            if ("consumerBeam".equals(beanName)) {
            //                ConsumerBean bean = (ConsumerBean) beanFactory.getBean(beanName);
            //                Properties defaultProperties = new Properties();
            //                defaultProperties.put("name", "new java");
            //                Properties newDefaultProperties = new Properties(defaultProperties);
            //                bean.setProperties(newDefaultProperties);
            //            }
            /**
             * 4
             * 执行结果:
             *  createConsumer start,properties name=new java
             *  consumerBean name=new java
             *  properties name=java
             */
            if ("consumerBeam".equals(beanName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                Properties defaultProperties = new Properties();
                defaultProperties.put("name", "new java");
                Properties newDefaultProperties = new Properties(defaultProperties);
                beanDefinition.getPropertyValues().add("properties", newDefaultProperties);
            }

        }
    }
}
