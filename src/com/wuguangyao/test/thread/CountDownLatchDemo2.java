package com.wuguangyao.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>TODO</p>
 *
 * @author guangyao.wu@ucarinc.com
 * @date 2019/8/15 13:49
 **/
public class CountDownLatchDemo2 {

    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(N);
        Executor e = Executors.newCachedThreadPool();

        for (int i = 0; i < N; ++i) {
            e.execute(new Worker(doneSignal));
        }
        Thread.sleep(2000);
        doneSignal.await();
        System.out.println(doneSignal.getCount());
        doneSignal = new CountDownLatch(N);
        for (int i = N; i < N + N; ++i) {
            e.execute(new Worker(doneSignal));
        }
        Thread.sleep(2000);
        doneSignal.await();
        System.out.println(doneSignal.getCount());
        System.exit(0);
    }


    static class Worker extends Thread {
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch doneSignal) {
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void doWork() throws InterruptedException {
            System.out.println("线程："+this.getName());
        }
    }

}
