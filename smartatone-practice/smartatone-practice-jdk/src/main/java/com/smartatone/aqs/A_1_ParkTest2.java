package com.smartatone.aqs;

import java.util.concurrent.locks.LockSupport;

public class A_1_ParkTest2 {
    /**
     * 执行结果:
     *      main into!
     *      a
     *      b
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " into!");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.park();
        System.out.println("c");
    }
}
