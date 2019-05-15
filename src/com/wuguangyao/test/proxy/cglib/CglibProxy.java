package com.wuguangyao.test.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author guangyao.wu@ucarinc.com
 * @description TODO
 * @date 2019/5/15 17:01
 **/
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        methodProxy.invokeSuper(o, objects);
        return o;
    }
}
