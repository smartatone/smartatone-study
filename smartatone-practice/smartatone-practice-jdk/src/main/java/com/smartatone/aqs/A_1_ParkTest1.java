package com.smartatone.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class A_1_ParkTest1 {
    /**
     * 执行结果:
     *      Thread-0 start
     *      main unpark sub!
     *      Thread-0 end
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " end");
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " unpark sub!");
        LockSupport.unpark(t);
    }
}
