package com.smartatone.aqs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: park
 * @create 2020-04-20 8:12
 **/
public class A_1_Park implements Runnable {
    private Thread     next;
    private DateFormat df = new SimpleDateFormat("HH:mm:ss");

    A_1_Park(Thread next) {
        this.next = next;
    }

    /**
     * 
     * 执行结果:
     *      Thread-0 into!time=08:55:00
     *      Thread-0 park!
     *      Thread-1 into!time=08:55:00
     *      Thread-1 out!time=08:55:05
     *      Thread-0 out!time=08:55:10
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new A_1_Park(null));
        Thread t2 = new Thread(new A_1_Park(t1));
        t1.start();
        t2.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " into!time=" + df.format(new Date()));
        if (next == null) {
            System.out.println(Thread.currentThread().getName() + " park!");
            LockSupport.park(this);
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " out!time=" + df.format(new Date()));
        LockSupport.unpark(next);
    }
}
