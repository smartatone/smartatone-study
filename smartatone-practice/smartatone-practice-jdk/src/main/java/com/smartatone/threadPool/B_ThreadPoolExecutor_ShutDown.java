package com.smartatone.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: 线程池shut_down
 * @create 2020-04-18 14:06
 **/
public class B_ThreadPoolExecutor_ShutDown implements Runnable {
    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(5));
    private int                       i;

    B_ThreadPoolExecutor_ShutDown(int i) {
        this.i = i;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("thread " + i + " into!");
        Thread.sleep(1000);
        System.out.println("thread " + i + " out!");
    }

    /**
     * 执行结果:
     * thread 0 into!
     * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.smartatone.threadPool.B_ThreadPoolExecutor_PoolStatus@3764951d rejected from java.util.concurrent.ThreadPoolExecutor@4b1210ee[Shutting down, pool size = 1, active threads = 1, queued tasks = 2, completed tasks = 0]
     * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
     * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
     * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
     * 	at com.smartatone.threadPool.B_ThreadPoolExecutor_PoolStatus.main(B_ThreadPoolExecutor_ShutDown.java:38)
     * thread 0 out!
     * thread 1 into!
     * thread 1 out!
     * thread 2 into!
     * thread 2 out!
     * 解析:
     *  0进入corePoolSize
     *  1，2进入队列
     *  执行shutdown，不再接收新的任务
     *  3进入队列失败，报错
     *  0,1,2,执行完成后，线程池进入TIDYING->TERMINATED状态，进程结束
     */
    @SneakyThrows
    public static void main(String[] args) {
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDown(0));
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDown(1));
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDown(2));
        Thread.sleep(10);
        poolExecutor.shutdown();
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDown(3));
    }

}
