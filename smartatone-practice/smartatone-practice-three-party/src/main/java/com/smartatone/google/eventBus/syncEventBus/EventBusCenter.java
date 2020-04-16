package com.smartatone.google.eventBus.syncEventBus;

import com.google.common.eventbus.EventBus;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EventBusCenter {

    private EventBus eventBus;

    public void register(Object obj) {
        eventBus.register(obj);
    }

    public void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public void post(Object obj) {
        eventBus.post(obj);
    }

}
