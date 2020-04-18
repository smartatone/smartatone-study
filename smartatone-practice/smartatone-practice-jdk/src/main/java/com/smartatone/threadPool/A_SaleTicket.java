package com.smartatone.threadPool;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: 多线程卖票
 * @create 2020-04-17 21:52
 **/
public class A_SaleTicket {

    /**
     * Thread-1卖出第1张，还剩下10张
     * Thread-1卖出第2张，还剩下9张
     * Thread-1卖出第3张，还剩下8张
     * Thread-1卖出第4张，还剩下7张
     * Thread-1卖出第5张，还剩下6张
     * Thread-1卖出第6张，还剩下5张
     * Thread-1卖出第7张，还剩下4张
     * Thread-1卖出第8张，还剩下3张
     * Thread-1卖出第9张，还剩下2张
     * Thread-1卖出第10张，还剩下1张
     * Thread-0卖出第1张，还剩下10张
     * Thread-0卖出第2张，还剩下9张
     * Thread-0卖出第3张，还剩下8张
     * Thread-0卖出第4张，还剩下7张
     * Thread-0卖出第5张，还剩下6张
     * Thread-0卖出第6张，还剩下5张
     * Thread-0卖出第7张，还剩下4张
     * Thread-0卖出第8张，还剩下3张
     * Thread-0卖出第9张，还剩下2张
     * Thread-0卖出第10张，还剩下1张
     * -----------------------
     * Thread-2卖出第1张，还剩下10张
     * Thread-3卖出第1张，还剩下9张
     * Thread-2卖出第2张，还剩下8张
     * Thread-3卖出第2张，还剩下7张
     * Thread-2卖出第3张，还剩下6张
     * Thread-3卖出第3张，还剩下5张
     * Thread-2卖出第4张，还剩下4张
     * Thread-3卖出第4张，还剩下3张
     * Thread-2卖出第5张，还剩下2张
     * Thread-3卖出第5张，还剩下1张
     * Thread-2卖出第6张，还剩下0张
     */
    public static void main(String[] args) throws InterruptedException {
        SaleThread saleThread1 = new SaleThread();
        saleThread1.start();
        SaleThread saleThread2 = new SaleThread();
        saleThread2.start();
        Thread.sleep(1000);
        System.out.println("-----------------------");
        SaleRunnable saleRunnable = new SaleRunnable();
        new Thread(saleRunnable).start();
        new Thread(saleRunnable).start();
    }
}

class SaleThread extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + i + "张，还剩下" + ticket-- + "张");
            }
        }
    }
}

class SaleRunnable implements Runnable {
    private int ticket = 10;

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (ticket > 0) {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + "卖出第" + i + "张，还剩下" + ticket-- + "张");
            }
        }
    }
}
