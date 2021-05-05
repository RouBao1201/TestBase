package com.syb.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Abin
 * @date Created in 2021/5/4 22:48
 * @Modified By:
 * @Description 自定义注解：控制事务
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RUNTIME)
@Documented
public @interface TransactionMyself {
}
