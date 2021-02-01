package com.wuguangyao.test.proxy.jdk;

/**
 * @author guangyao.wu@ucarinc.com
 * @description TODO
 * @date 2019/5/15 16:43
 **/
public class Client {

    public static void main(String[] args) {
        // jdk动态代理测试
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.methodB();
        System.out.println();
    }

}
