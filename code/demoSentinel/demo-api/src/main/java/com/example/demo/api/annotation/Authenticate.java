package com.example.demo.api.annotation;

import java.lang.annotation.*;

/**
 * @Author mubi
 * @Date 2019/7/13 7:56 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Authenticate {
    /**
     * 是否需要校验访问权限 默认不校验
     *
     * @return
     */
    boolean permission() default false;
}
