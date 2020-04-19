package com.smartatone.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xuyang001
 * @Description: 队列查看
 * @create 2020-04-19 12:17
 **/
public class A_3_QueueExamineTest {

    public static void main(String[] args) {
        queueElement();
        queuePeek();
    }

    /**
     * 执行结果:
     *      [1]
     *      queue element =1
     *      []
     *      Exception in thread "main" java.util.NoSuchElementException
     * 	        at java.util.AbstractQueue.element(AbstractQueue.java:136)
     * 	        at com.smartatone.queue.A_3_QueueExamineTest.queueElemet(A_3_QueueExamineTest.java:21)
     * 	        at com.smartatone.queue.A_3_QueueExamineTest.main(A_3_QueueExamineTest.java:13)
     * 总结:
     *      检查头部元素，如果数组为空，则抛异常
     */
    public static void queueElement() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.offer(1);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            Integer element = queue.element();
            System.out.println("queue element =" + element);
            queue.poll();
        }
        System.out.println("queue add end!");
    }

    /**
     * 执行结果:
     *      [1]
     *      queue peek =1
     *      []
     *      queue peek =null
     *      []
     *      queue peek =null
     *      queue add end!
     * 总结:
     *      检查队列头部元素，如果队列为空，则返回空
     */
    public static void queuePeek() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.offer(1);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue);
            Integer element = queue.peek();
            System.out.println("queue peek =" + element);
            queue.poll();
        }
        System.out.println("queue add end!");
    }
}
