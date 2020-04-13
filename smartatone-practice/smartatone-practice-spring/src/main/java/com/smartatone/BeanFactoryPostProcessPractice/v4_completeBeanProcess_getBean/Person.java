package com.smartatone.BeanFactoryPostProcessPractice.v4_completeBeanProcess_getBean;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

public class Person
        implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
        BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware, InitializingBean, DisposableBean {
    private String      name;
    private String      address;
    private String      phone;
    private BeanFactory beanFactory;
    private String      beanName;

    public Person() {
        System.out.println("Person contruct()");
    }

    public void setName(String name) {
        System.out.println("Person setName()");
        this.name = name;
    }

    public void setAddress(String address) {
        System.out.println("Person setAddress()");
        this.address = address;
    }

    public void setPhone(String phone) {
        System.out.println("Person setPhone()");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone=" + phone + "]";
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法(Person)");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法(Person)");
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = arg0;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    //ApplicationContextAware的接口方法
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(
                "【ApplicationContextAware接口】调用ApplicationContextAware.setApplicationContext(),Bean  Definition Names="
                        + Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }

    //ApplicationEventPublisherAware的接口方法
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println(
                "【ApplicationEventPublisherAware接口】调用ApplicationEventPublisherAware.setApplicationEventPublisher()");
    }

    //BeanClassLoaderAware的接口方法
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println(
                "【BeanClassLoaderAware接口】执行setBeanClassLoader,ClassLoader Name = " + classLoader.getClass().getName());
    }

    //EnvironmentAware的接口方法
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("【EnvironmentAware接口】调用EnvironmentAware.setEnvironment()");
    }

    //ImportAware的接口方法
    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        System.out.println("【ImportAware接口】调用ImportAware.setImportMetadata()");
    }

    //ResourceLoaderAware的接口方法
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("【ResourceLoaderAware接口】调用ResourceLoaderAware.setResourceLoader()");
        Resource resource = resourceLoader.getResource("classpath:beans.xml");
        System.out.println("执行setResourceLoader::  Resource File Name=" + resource.getFilename());
    }
}
