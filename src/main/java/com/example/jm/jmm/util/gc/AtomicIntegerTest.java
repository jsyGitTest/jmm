package com.example.jm.jmm.util.gc;

import org.apache.poi.hssf.record.formula.functions.T;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  @Author 捡田螺的小男孩
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
//        A a1 = new A();
//        A a2 = new A();
//        A a3 = new A();
//        Thread thread1 = new Thread();
//        Thread thread2 = new Thread();
//        Thread thread3 = new Thread();
//
//        a1.start();
//        a2.start();
//        a3.start();
//        thread2.start();
//        thread3.start();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
//        A a1 = new A();
//        for (int i = 0; i < 3; i++) {
//            threadPoolExecutor.execute(a1);
//
//        }
       // threadPoolExecutor.execute(a1);

        A a1 = new A();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(a1);
        }



    }

}

class A extends Thread{
    private static int ticket = 10000;
    ReentrantLock lock = new ReentrantLock();
    public void run (){
        while (true){
            lock.lock();
            if (ticket >= 0) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "剩余票" + ticket--);
            }
            lock.unlock();
        }
    }

}

