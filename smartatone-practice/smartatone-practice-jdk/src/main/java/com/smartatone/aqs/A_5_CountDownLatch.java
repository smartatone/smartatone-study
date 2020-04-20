package com.smartatone.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import lombok.SneakyThrows;

public class A_5_CountDownLatch {

    /**
     * 执行结果:
     *      main into!
     *      sub Thread-0 into!
     *      sub Thread-1 into!
     *      sub Thread-2 into!
     *      sub Thread-0 out!
     *      sub Thread-2 out!
     *      sub Thread-1 out!
     *      main out!
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        System.out.println(Thread.currentThread().getName() + " into!");

        Stream.iterate(0, i -> i + 1).limit(3).forEach(t -> {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println("sub " + Thread.currentThread().getName() + " into!");
                    TimeUnit.MINUTES.sleep(1);
                    System.out.println("sub " + Thread.currentThread().getName() + " out!");
                    latch.countDown();
                }
            }).start();
        });

        latch.await();

        System.out.println(Thread.currentThread().getName() + " out!");
    }
}
