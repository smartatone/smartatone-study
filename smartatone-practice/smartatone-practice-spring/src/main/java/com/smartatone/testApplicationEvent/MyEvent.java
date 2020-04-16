package com.smartatone.testApplicationEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @author xuyang001
 * @Description: 自定义event
 * @create 2020-04-16 21:38
 **/
public class MyEvent extends ApplicationEvent {
    private String name;

    public MyEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
