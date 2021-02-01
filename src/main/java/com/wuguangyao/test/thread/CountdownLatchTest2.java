package com.wuguangyao.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>TODO</p>
 *
 * @author guangyao.wu@ucarinc.com
 * @date 2019/8/15 10:47
 **/
public class CountdownLatchTest2 {

    public static void main(String[] args) {
        ExecutorService service = Executors. newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            service.execute(()->{
                try {
                    System. out.println("选手" + Thread.currentThread().getName() + "正等待裁判发布口令");
                    cdOrder.await();
                    System. out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
                    Thread.sleep(5000);
                    System. out.println("选手" + Thread.currentThread().getName() + "到达终点");
                    cdAnswer.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            Thread.sleep(5000);
            System. out.println("裁判" + Thread.currentThread ().getName() + "即将发布口令" );
            System. out.println("裁判" + Thread.currentThread ().getName() + "已发送口令，正在等待所有选手到达终点" );
            cdOrder.countDown();
            cdAnswer.await();
            System. out.println("所有选手都到达终点" );
            System. out.println("裁判" + Thread.currentThread ().getName() + "汇总成绩排名" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();

    }

}
