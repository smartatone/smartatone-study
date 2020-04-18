package com.smartatone.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: 线程池shut_down_now
 * @create 2020-04-18 14:06
 **/
public class B_ThreadPoolExecutor_ShutDownNow implements Runnable {
    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(5));
    private int                       i;

    B_ThreadPoolExecutor_ShutDownNow(int i) {
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
     * Exception in thread "pool-1-thread-1" Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.smartatone.threadPool.B_ThreadPoolExecutor_ShutDownNow@3764951d rejected from java.util.concurrent.ThreadPoolExecutor@4b1210ee[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 1]
     * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
     * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
     * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
     * 	at com.smartatone.threadPool.B_ThreadPoolExecutor_ShutDownNow.main(B_ThreadPoolExecutor_ShutDownNow.java:57)
     * java.lang.Error: java.lang.InterruptedException: sleep interrupted
     * 	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1148)
     * 	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
     * 	at java.lang.Thread.run(Thread.java:748)
     * Caused by: java.lang.InterruptedException: sleep interrupted
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at com.smartatone.threadPool.B_ThreadPoolExecutor_ShutDownNow.run(B_ThreadPoolExecutor_ShutDownNow.java:27)
     * 	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
     * 	... 2 more
     * 解析:
     *  0进入corePoolSize
     *  执行shutdownNow,所有任务被终止掉(包括正在处理中的)
     */
    @SneakyThrows
    public static void main(String[] args) {
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDownNow(0));
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDownNow(1));
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDownNow(2));
        Thread.sleep(10);
        poolExecutor.shutdownNow();
        poolExecutor.execute(new B_ThreadPoolExecutor_ShutDownNow(3));
    }

}
