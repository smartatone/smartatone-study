package com.smartatone.google.eventBus.syncEventBus;

import com.google.common.eventbus.Subscribe;
import com.smartatone.google.eventBus.asyncEventBus.DemoEvent;

public class DataObserver1 {

    @Subscribe
    public void func(DemoEvent demoEvent) {

        System.out.println("DataObserver1 : " + demoEvent.getId());

    }

}
