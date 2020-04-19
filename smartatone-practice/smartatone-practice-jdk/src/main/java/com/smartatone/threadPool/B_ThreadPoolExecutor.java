package com.smartatone.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * 执行结果:
 *  thread 0 into!
 * thread 2 into!
 * thread 3 into!
 * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.smartatone.threadPool.RunnableTest@6f79caec rejected from java.util.concurrent.ThreadPoolExecutor@6aceb1a5[Running, pool size = 3, active threads = 3, queued tasks = 1, completed tasks = 0]
 * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
 * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
 * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
 * 	at com.smartatone.threadPool.B_ThreadPoolExecutor.main(B_ThreadPoolExecutor.java:21)
 * thread 0 out!
 * thread 1 into!
 * thread 2 out!
 * thread 3 out!
 * thread 1 out!
 *  执行分析：
 *  thread 0进入corePool
 *  thread 1 进入workQueue
 *  thread 2,3进入时，corePool和workQueue都已经满了，所以开启新的线程执行
 *  thread 4进入，corePool,workQueue和maximumPoolSize都满了，所以执行报错，跳出循环
 **/
public class B_ThreadPoolExecutor {

    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 3, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(new RunnableTest(i));
        }
    }
}

class RunnableTest implements Runnable {
    private int i;

    public RunnableTest(int i) {
        this.i = i;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("thread " + i + " into!");
        Thread.sleep(10000);
        System.out.println("thread " + i + " out!");
    }
}
