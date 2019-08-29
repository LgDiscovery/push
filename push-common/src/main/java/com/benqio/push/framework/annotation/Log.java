package com.benqio.push.framework.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * 
 * @since 2017-05-15 14:03:48
 * @version v1.0.0
 * @author jinyifeng5969@163.com
 */
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    
    /** 操作描述 */
    String value() default "";
}