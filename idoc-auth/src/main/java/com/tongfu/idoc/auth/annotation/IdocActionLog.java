package com.tongfu.idoc.auth.annotation;


import java.lang.annotation.*;

/**
 * @auther Deubugxiaowangzi
 * @date 2018/12/5 10:43
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface IdocActionLog {
    int type() default 1;

    String who() default "daisheng.wang";

    String IdocAction() default "read";


}
