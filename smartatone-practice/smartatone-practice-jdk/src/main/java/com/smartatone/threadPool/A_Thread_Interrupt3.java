package com.smartatone.threadPool;

/**
 * @author xuyang001
 * @Description: interrupt
 * @create 2020-04-18 16:53
 **/
public class A_Thread_Interrupt3 {

    /**
     * 
     * 执行结果:
     *      ....
     *  分析:
     *      interrupt()不能中断<br>运行中</>的线程
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                System.out.println(i + " while循环");
                i++;
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
