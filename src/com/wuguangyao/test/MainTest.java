package com.wuguangyao.test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            int j = i;
            Thread t = new Thread(() -> System.out.println("线程---t" + j));
            list.add(t);
            t.start();
        }
        System.out.println("main 线程---");

    }
}
