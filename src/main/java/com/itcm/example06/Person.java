package com.itcm.example06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Person {
    String name() default "";
    SexEnum sex() default SexEnum.UNKNOWN;
    int age() default 18;

}
