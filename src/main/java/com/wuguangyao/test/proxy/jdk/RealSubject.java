package com.wuguangyao.test.proxy.jdk;

/**
 * @author guangyao.wu@ucarinc.com
 * @description TODO
 * @date 2019/5/15 16:41
 **/
public class RealSubject implements Subject {

    public void methodA() {
        System.out.println("RealSubject.methodA()");
    }

    public void methodB() {
        System.out.println("Begin RealSubject.methodB");
        this.methodA();
        System.out.println("End RealSubject.methodB");
    }
}
