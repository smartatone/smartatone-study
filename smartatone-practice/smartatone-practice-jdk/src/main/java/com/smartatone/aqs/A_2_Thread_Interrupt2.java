package com.smartatone.aqs;

/**
 * @author xuyang001
 * @Description: interrupt
 * @create 2020-04-18 16:53
 **/
public class A_2_Thread_Interrupt2 {

    /**
     * 
     * 执行结果:
     *      进入睡眠状态
     *      睡眠被中断
     *      run方法执行完毕
     *  分析:
     *      interrupt()可通过抛出异常的方式中断<br>阻塞中</>的线程
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("进入睡眠状态");
            try {
                Thread.currentThread().sleep(10000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("睡眠被中断");
            }
            System.out.println("run方法执行完毕");
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
