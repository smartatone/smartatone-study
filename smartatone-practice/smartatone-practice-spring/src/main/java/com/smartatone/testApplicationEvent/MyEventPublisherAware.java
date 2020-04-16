package com.smartatone.testApplicationEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author xuyang001
 * @Description: 自定义publishAware
 * @create 2020-04-16 21:40
 **/
public class MyEventPublisherAware implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.applicationEventPublisher = publisher;
    }

    public boolean test(String name) {
        //发布自定义事件
        applicationEventPublisher.publishEvent(new MyEvent(this, name));
        return true;
    }

}
