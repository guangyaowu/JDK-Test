package com.wuguangyao.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>TODO</p>
 *
 * @author guangyao.wu@ucarinc.com
 * @date 2019/8/15 11:23
 **/

public class Driver {
    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; ++i) {
            new Thread(new Worker(startSignal, doneSignal, "Thread-" + i)).start();
        }

        doSomethingElse();
        startSignal.countDown();
        doneSignal.await();
        doSomethingElse();
    }

    static void doSomethingElse() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("线程："+Thread.currentThread().getName()+"睡眠2秒");
    }

    static class Worker extends Thread {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal, String name) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
            this.setName(name);
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void doWork() throws InterruptedException {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("线程："+this.getName()+"睡眠3秒");
        }
    }
}
