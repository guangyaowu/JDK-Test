package com.wuguangyao.test.proxy.cglib;

/**
 * @author guangyao.wu@ucarinc.com
 * @description TODO
 * @date 2019/5/15 17:03
 **/
public class UserDao {

    public void update() {
        System.out.println("userDao.update()");
    }

    public void complex() {
        System.out.println("begin complex()");
        this.update();
        System.out.println("end complex()");
    }
}
