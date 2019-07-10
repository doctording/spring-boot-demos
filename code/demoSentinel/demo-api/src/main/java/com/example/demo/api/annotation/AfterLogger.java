package com.example.demo.api.annotation;

import java.lang.annotation.*;

/**
 * @Author mubi
 * @Date 2019/7/9 11:52 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface AfterLogger {
}
