package com.wuguangyao.test.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author guangyao.wu@ucarinc.com
 * @description TODO
 * @date 2019/5/15 17:02
 **/
public class Client {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(proxy);
        UserDao dao = (UserDao)enhancer.create();
        dao.complex();
    }

}
