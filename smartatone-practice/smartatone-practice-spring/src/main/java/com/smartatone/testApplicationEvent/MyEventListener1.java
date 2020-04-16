package com.smartatone.testApplicationEvent;

import org.springframework.context.ApplicationListener;

/**
 * @author xuyang001
 * @Description: 自定义Listener
 * @create 2020-04-16 21:43
 **/
public class MyEventListener1 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyEventListener1 " + event.getName());
    }
}
