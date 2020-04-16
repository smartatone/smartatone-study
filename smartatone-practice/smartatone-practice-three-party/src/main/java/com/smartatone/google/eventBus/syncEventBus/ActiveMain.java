package com.smartatone.google.eventBus.syncEventBus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smartatone.google.eventBus.asyncEventBus.DemoEvent;

public class ActiveMain {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/google/syncEventBus.xml");

        EventBusCenter eventBusCenter = applicationContext.getBean(EventBusCenter.class);
        DataObserver1 dataObserver1 = applicationContext.getBean(DataObserver1.class);
        DataObserver2 dataObserver2 = applicationContext.getBean(DataObserver2.class);

        eventBusCenter.register(dataObserver1);
        eventBusCenter.register(dataObserver2);

        for (int i = 0; i < 30; i++) {
            Thread.sleep(1000);
            DemoEvent demoEvent = new DemoEvent();
            demoEvent.setId(Long.parseLong(i + ""));
            eventBusCenter.post(demoEvent);
            if (i == 15) {
                //注销一个
                eventBusCenter.unregister(dataObserver2);
            }
        }
    }
}
