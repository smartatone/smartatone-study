package com.smartatone.queue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: 队列插入
 * @create 2020-04-19 11:33
 **/
public class A_1_QueueInertTest {

    public static void main(String[] args) {
        queueAdd();
        queueOffer();
        queueOfferOfTime();
        queuePut();
    }

    /**
     * 执行结果:
     *      []
     *      [0]
     *      [0, 1]
     *      Exception in thread "main" java.lang.IllegalStateException: Queue full
     * 	    at java.util.AbstractQueue.add(AbstractQueue.java:98)
     *  	at com.smartatone.queue.A_1_QueueTest.main(A_1_QueueTest.java:21)
     *  总结：
     *      add 会抛异常
     */
    public static void queueAdd() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            queue.add(i);
        }
        System.out.println("queue add end!");
    }

    /**
     * 执行结果:
     *      []
     *      [0]
     *      [0, 1]
     *      [0, 1]
     *      queue offer end!
     * 总结:
     *      不会抛异常也不会放入新数据，执行完线程终止
     */
    public static void queueOffer() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue);
            queue.offer(i);
        }
        System.out.println("queue offer end!");
    }

    /**
     * 执行结果:
     *      []
     *      12:01:56
     *      [0]
     *      12:01:56
     *      [0, 1]
     *      12:01:56
     *      [0, 1]
     *      12:02:01
     *      12:02:06
     *      queue offer end!
     *  总结:
     *      不会报错，队列不够时阻塞，阻塞指定时间后退出
     */
    @SneakyThrows
    public static void queueOfferOfTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue);
            System.out.println(dateFormat.format(new Date()));
            queue.offer(i, 5, TimeUnit.SECONDS);
        }
        System.out.println(dateFormat.format(new Date()));
        System.out.println("queue offer end!");
    }

    /**
     * 执行结果:
     *      []
     *      [0]
     *      [0, 1]
     *      [0, 1]
     * 总结:
     *      线程一直会阻塞，等待queue有足够空间插入
     */
    @SneakyThrows
    public static void queuePut() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            queue.put(i);
        }

        System.out.println("queue put end!");
    }
}
