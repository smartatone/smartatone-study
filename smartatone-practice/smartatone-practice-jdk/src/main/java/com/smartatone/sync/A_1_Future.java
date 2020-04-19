package com.smartatone.sync;

import java.util.concurrent.*;

/**
 * @author xuyang001
 * @Description: 异步带返回值任务
 * @create 2020-04-18 21:21
 **/
public class A_1_Future {
    private static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + " into! ");
        //只是ThreadPoolExecutor里面封装了new Future()的方法
        Future<Integer> submit = threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(10);
                return 1;
            }
        });
        Integer integer = submit.get();
        System.out.println(Thread.currentThread().getName() + " out! i= " + integer);

    }

}
