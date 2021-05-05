package com.syb.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Abin
 * @date Created in 2021/5/5 1:46
 * @Modified By:
 * @Description
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
public @interface MinValidMyself {
    String message() default "{javax.validation.constraints.Min.message}";
    int value() default 0;
}
