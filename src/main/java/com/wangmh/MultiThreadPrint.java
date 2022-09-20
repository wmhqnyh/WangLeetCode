package com.wangmh;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wang.mh
 * @date : 2022/9/20 13:55
 * <p>
 * 多线程交替打印ABC
 * ReentrantLock方式
 */
public class MultiThreadPrint {

    static int count = 0;

    public void print() {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread threadA = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (count < 100) {
                        System.out.println("A");
                        count++;
                        conditionB.signal();
                    }
                    conditionA.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    conditionB.await();
                    if (count < 100) {
                        System.out.println("B");
                        count++;
                        conditionC.signal();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    conditionC.await();
                    if (count < 100) {
                        System.out.println("C");
                        count++;
                        conditionA.signal();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        threadC.start();
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadA.start();
    }

    public static void main(String[] args) {
        new MultiThreadPrint().print();
    }

}
