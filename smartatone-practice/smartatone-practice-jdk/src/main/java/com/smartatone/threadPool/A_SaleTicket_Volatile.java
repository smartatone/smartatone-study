package com.smartatone.threadPool;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: volatile关键字
 * @create 2020-04-17 22:12
 **/
public class A_SaleTicket_Volatile {
    private static int          ticket  = 20;

    private static volatile int ticket2 = 20;

    @SneakyThrows
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable(ticket);
        for (int i = 0; i < 2; i++) {
            new Thread(myRunnable).start();
        }

        Thread.sleep(1000);
        System.out.println("--------------");

        MyRunnable myRunnable2 = new MyRunnable(ticket2);
        for (int i = 0; i < 2; i++) {
            new Thread(myRunnable2).start();
        }
    }
}

class MyRunnable implements Runnable {
    private int ticket;

    public MyRunnable(int i) {
        this.ticket = i;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (ticket > 0) {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + "卖出第" + i + "张，还剩下" + --ticket + "张");
            }
        }
    }
}
