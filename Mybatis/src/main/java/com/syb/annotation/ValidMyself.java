package com.syb.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Abin
 * @date Created in 2021/5/5 0:39
 * @Modified By:
 * @Description
 */
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER,TYPE})
@Retention(RUNTIME)
@Documented
public @interface ValidMyself {
}
