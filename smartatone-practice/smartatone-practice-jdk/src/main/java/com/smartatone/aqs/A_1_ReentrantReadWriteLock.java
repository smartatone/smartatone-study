package com.smartatone.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Stream;

import lombok.SneakyThrows;

/**
 * @author xuyang001
 * @Description: 读写锁
 * @create 2020-04-18 17:37
 **/
public class A_1_ReentrantReadWriteLock {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        /**
         * 打印结果：
         *      Thread-0 into
         *      Thread-0 lock!
         *      Thread-1 into
         *      Thread-1 lock!
         *      Thread-2 into
         *      Thread-2 lock!
         *      Thread-2 out
         *      Thread-2 unlock!
         *      Thread-1 out
         *      Thread-1 unlock!
         *      Thread-0 out
         *      Thread-0 unlock!
         * 结论：
         *      读锁之间不互斥
         */
        A_1_Read_ReadRunnble readReadRunnble = new A_1_Read_ReadRunnble(lock);
        Stream.iterate(0, i -> i + 1).limit(3).forEach(t -> {
            new Thread(readReadRunnble).start();
        });
        /**
         * 打印结果:
         *      Thread-0 into write
         *      Thread-1 into write
         *      Thread-0 lock!
         *      Thread-0 out write
         *      Thread-0 unLock!
         *      Thread-1 lock!
         *      Thread-1 out write
         *      Thread-1 unLock!
         *  结论：
         *      写锁之间会互斥
         */
        A_1_Read_Read_Runnble a_1_read_read_runnble = new A_1_Read_Read_Runnble(lock);
        Stream.iterate(0, i -> i + 1).limit(2).forEach(t -> {
            new Thread(a_1_read_read_runnble).start();
        });
    }
}

class A_1_Read_ReadRunnble implements Runnable {
    private ReentrantReadWriteLock lock;

    A_1_Read_ReadRunnble(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " into");
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " lock!");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + " out");
        lock.readLock().unlock();
        System.out.println(Thread.currentThread().getName() + " unlock!");
    }
}

class A_1_Read_Read_Runnble implements Runnable {
    private ReentrantReadWriteLock lock;

    A_1_Read_Read_Runnble(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " into write");
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " lock!");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " out write");
        lock.writeLock().unlock();
        System.out.println(Thread.currentThread().getName() + " unLock!");
    }
}
