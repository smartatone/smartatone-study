package com.smartatone.google.eventBus.syncEventBus;

import com.google.common.eventbus.Subscribe;
import com.smartatone.google.eventBus.asyncEventBus.DemoEvent;

public class DataObserver2 {

    /**
    
    * post() 不支持自动装箱功能,只能使用Integer,不能使用int,否则handlersByType的Class会是int而不是Intege
    
    * 而传入的int msg参数在post(int msg)的时候会被包装成Integer,导致无法匹配到
    
    */

    @Subscribe
    public void func(DemoEvent demoEvent) {
        System.out.println("DataObserver2 : " + demoEvent.getId());

    }

}
