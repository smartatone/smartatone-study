package com.smartatone.queue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: 队列删除
 * @create 2020-04-19 11:33
 **/
public class A_2_QueueDeleteTest {

    public static void main(String[] args) {
        queueRemove();
        queuePoll();
        queuePollOfTime();
        queueTake();
    }

    /**
     * 执行结果
     *      [1, 2]
     *      remove i=0 result=false
     *      [1, 2]
     *      remove i=1 result=true
     *      [2]
     *      remove i=2 result=true
     *      queue remove end!
     *  总结:
     *      删除队列指定元素，成功为true,失败为false，执行完成结束线程
     */
    public static void queueRemove() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.offer(1);
        queue.offer(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            boolean remove = queue.remove(i);
            System.out.println("remove i=" + i + " result=" + remove);
        }
        System.out.println("queue remove end!");
    }

    /**
     * 执行结果:
     *      [1, 2]
     *      poll i=0 result=1
     *      [2]
     *      poll i=1 result=2
     *      []
     *      poll i=2 result=null
     *      System.out.println("queue poll end!");
     *  总结:
     *      删除队列头部元素并返回，队列为空返回null
     */
    public static void queuePoll() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.offer(1);
        queue.offer(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            Integer result = queue.poll();
            System.out.println("poll i=" + i + " result=" + result);
        }
        System.out.println("queue poll end!");
    }

    /**
     * 执行结果:
     *      [1, 2]
     *      12:13:59
     *      poll i=0 result=1
     *      [2]
     *      12:13:59
     *      poll i=1 result=2
     *      []
     *      12:14:04
     *      poll i=2 result=null
     *      queue poll end!
     *  总结:
     *      删除头部元素并返回，如果队列为空，阻塞指定时间后退出
     */
    @SneakyThrows
    public static void queuePollOfTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.offer(1);
        queue.offer(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            Integer result = queue.poll(5, TimeUnit.SECONDS);
            System.out.println(dateFormat.format(new Date()));
            System.out.println("poll i=" + i + " result=" + result);
        }
        System.out.println("queue poll end!");
    }

    /**
     * 执行结果:
     *      [1, 2]
     *      take i=0 result=1
     *      [2]
     *      take i=1 result=2
     *      []
     *  总结:
     *      删除头部元素并返回，如果队列为空，则一直阻塞
     */
    @SneakyThrows
    public static void queueTake() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.offer(1);
        queue.offer(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            Integer result = queue.take();
            System.out.println("take i=" + i + " result=" + result);
        }
        System.out.println("queue take end!");
    }
}
