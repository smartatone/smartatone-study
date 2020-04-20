package com.smartatone.aqs;

import java.util.concurrent.TimeUnit;

/**
 * @author xuyang001
 * @Description: interrupt
 * @create 2020-04-18 16:53
 **/
public class A_2_Thread_Interrupt1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                boolean in = Thread.currentThread().isInterrupted();
                if (in) {
                    System.out.println("before " + in);
                    System.out.println("after " + in);
                    System.out.println(in);
                    Thread.interrupted();//复位
                }
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();//中断线程
    }
}
