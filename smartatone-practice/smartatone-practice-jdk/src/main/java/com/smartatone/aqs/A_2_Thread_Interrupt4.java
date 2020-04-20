package com.smartatone.aqs;

/**
 * @author xuyang001
 * @Description: interrupt
 * @create 2020-04-18 16:53
 **/
public class A_2_Thread_Interrupt4 {

    /**
     * 
     * 执行结果:
     *      ....
     *  分析:
     *      interrupt()和isInterrupted()一起使用可以中断运行中的线程
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted() && i < Integer.MAX_VALUE) {
                System.out.println(i + " while循环");
                i++;
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
