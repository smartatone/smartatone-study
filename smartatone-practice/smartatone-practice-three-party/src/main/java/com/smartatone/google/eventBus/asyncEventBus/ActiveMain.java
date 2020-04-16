package com.smartatone.google.eventBus.asyncEventBus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.eventbus.AsyncEventBus;

public class ActiveMain {

    public static void main(String[] args) {
        //这里没有注解，所以从上下文里获取
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/google/asyncEventBus.xml");

        AsyncEventBus asyncEventBus = applicationContext.getBean(AsyncEventBus.class);
        DemoEventListener1 listener1 = applicationContext.getBean(DemoEventListener1.class);
        DemoEventListener2 listener2 = applicationContext.getBean(DemoEventListener2.class);
        asyncEventBus.register(listener1);
        asyncEventBus.register(listener2);

        for (int i = 0; i < 100; i++) {
            DemoEvent demoEvent = new DemoEvent();
            demoEvent.setId(Long.parseLong(i + ""));
            asyncEventBus.post(demoEvent);
        }
    }
}
