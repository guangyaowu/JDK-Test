package com.wuguangyao.test;

import com.wuguangyao.test.demo.PO;
import com.wuguangyao.test.demo.TestAnnotation;

/**
 * <p>TODO</p>
 *
 * @author guangyao.wu@ucarinc.com
 * @date 2019/7/23 17:00
 **/
public class Main {

    public static void main(String[] args) {
        PO po = new PO();
        po.setCode("po-code");
        po.setName("po-name");

        Class<? extends PO> poClass = po.getClass();
        if(poClass.isAnnotationPresent(TestAnnotation.class)){
            TestAnnotation annotation = poClass.getAnnotation(TestAnnotation.class);
            po.setName(po.getName() + annotation.value());
            po.setCode(po.getCode() + annotation.value());
        }
        System.out.println(po);

    }

}
