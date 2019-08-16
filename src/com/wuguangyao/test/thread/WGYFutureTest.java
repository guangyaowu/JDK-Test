package com.wuguangyao.test.thread;

import java.util.concurrent.*;

/**
 * @author guangyao.wu
 * @description TODO
 * @date 2018/12/7 16:27
 **/
public class WGYFutureTest {


    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
            15,5, TimeUnit.MINUTES,new LinkedBlockingDeque<>());


    static class CallableTask implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return Integer.MAX_VALUE;
        }
    }

    static class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("WGYFutureTest");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<?> future = executor.submit(new RunnableTask());
        Object o = future.get();
        System.out.println(o);
        Future<Integer> integerFuture = executor.submit(new CallableTask());
        Integer integer = integerFuture.get();
        System.out.println(integer);
        System.exit(0);
    }



    class SynchronizedClass{
        private int value;
        public synchronized int get(){return value;}
        public synchronized void set(int value){this.value=value;}
    }

}
