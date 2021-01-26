package com.example.jm.jmm.util.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static int count = 100;

    public static void main(String[] args) throws Exception{

        ReentrantLock reentrantLock = new ReentrantLock();
        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(10,
                50,
                3l,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(50));


        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    reentrantLock.lock();
                    count--;
                    System.out.println("剩余票数"+count);
                    reentrantLock.unlock();
                }
            });
        }



    }
}
