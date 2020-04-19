package com.smartatone.sync;

import java.util.concurrent.*;

/**
 * @author xuyang001
 * @Description: 异步带返回值任务
 * @create 2020-04-18 21:21
 **/
public class A_1_FutureTask {
    private static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

    /**
     * 执行结果:
     *      1
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + " into!");
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(10);
                return 1;
            }
        });
        threadPoolExecutor.submit(futureTask);
        System.out.println(Thread.currentThread().getName() + " out! i= " + futureTask.get());
    }

}
