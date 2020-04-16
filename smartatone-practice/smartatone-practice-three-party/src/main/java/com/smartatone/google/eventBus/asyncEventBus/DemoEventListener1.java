package com.smartatone.google.eventBus.asyncEventBus;

import com.google.common.eventbus.Subscribe;

public class DemoEventListener1 {

    @Subscribe
    public void listener(DemoEvent demoEvent) {
        System.out.println("listener1 id=" + demoEvent.getId());
    }
}
