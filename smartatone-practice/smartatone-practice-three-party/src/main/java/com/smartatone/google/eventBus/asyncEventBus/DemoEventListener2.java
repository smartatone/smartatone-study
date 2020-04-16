package com.smartatone.google.eventBus.asyncEventBus;

import com.google.common.eventbus.Subscribe;

public class DemoEventListener2 {

    @Subscribe
    public void listener(DemoEvent demoEvent) {
        System.out.println("listener2 id=" + demoEvent.getId());
    }
}
