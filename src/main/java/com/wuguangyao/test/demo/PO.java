package com.wuguangyao.test.demo;

/**
 * <p>TODO</p>
 *
 * @author guangyao.wu@ucarinc.com
 * @date 2019/7/23 17:01
 **/
@TestAnnotation
public class PO {

    private String code;
    private String name;

    public String getCode() {
        return code;
    }
    @TestAnnotation("WWW-Code")
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    @TestAnnotation("WWW-Name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
