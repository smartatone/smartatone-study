package com.smartatone.google.eventBus.asyncEventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;

import lombok.Data;
import lombok.ToString;

/**
*
* 执行结果
 * 第0次发布消息!
 * 第1次发布消息!
 * EventServer1 : name=0
 * EventServer2 : name=0
 * EventServer1 : name=1
 * EventServer2 : name=1
 * 第2次发布消息!
 * 第3次发布消息!
 * EventServer2 : name=2
 * EventServer1 : name=2
 * 第4次发布消息!
 * EventServer1 : name=3
 * 第5次发布消息!
 * EventServer1 : name=5
 * EventServer1 : name=4
 * EventServer2 : name=3
 * EventServer2 : name=5
 * EventServer2 : name=4
 * 第6次发布消息!
 * 第7次发布消息!
 * EventServer2 : name=6
 * 第8次发布消息!
 * 第9次发布消息!
 * EventServer2 : name=7
 * EventServer2 : name=8
 * EventServer2 : name=9
*/
public class AsyncEventBusDemo {

    public static void main(String[] args) {
        //线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //消息发布器
        AsyncEventBus asyncEventBus = new AsyncEventBus(pool);

        //消息监听器
        EventServer1 eventServer1 = new EventServer1();
        EventServer2 eventServer2 = new EventServer2();

        //注册
        asyncEventBus.register(eventServer1);
        asyncEventBus.register(eventServer2);

        for (int i = 0; i < 10; i++) {
            EventDataDTO eventData = new EventDataDTO();
            eventData.setName("name=" + i);
            //发布消息
            System.out.println("第" + i + "次发布消息!");
            asyncEventBus.post(eventData);
            if (i == 5) {
                //取消注册
                asyncEventBus.unregister(eventServer1);
            }
        }
    }
}

//数据DTO
@Data
@ToString
class EventDataDTO {
    private String name;
}

//监听者1
class EventServer1 {
    @Subscribe
    public void handler(EventDataDTO eventData) {
        System.out.println("EventServer1 : " + eventData.getName());
    }
}

//监听者2
class EventServer2 {
    @Subscribe
    public void handler(EventDataDTO eventData) {
        System.out.println("EventServer2 : " + eventData.getName());
    }
}
