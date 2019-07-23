package com.wuguangyao.test.demo;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(value = {ElementType.TYPE,ElementType.METHOD})
public @interface TestAnnotation {

    String value() default "WGY-TestAnnotation";

}
