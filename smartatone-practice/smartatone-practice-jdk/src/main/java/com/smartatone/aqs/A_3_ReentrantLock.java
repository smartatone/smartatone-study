package com.smartatone.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: TODO
 * @create 2020-04-18 17:27
 **/
public class A_3_ReentrantLock implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    /**
     * 执行结果
     * Thread-1 into
     * Thread-1 out
     * Thread-0 into
     * Thread-0 out
     */
    public static void main(String[] args) {
        A_3_ReentrantLock test = new A_3_ReentrantLock();
        new Thread(test).start();
        new Thread(test).start();
    }

    @SneakyThrows
    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " into");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + " out");
        lock.unlock();
    }
}
