package com.benqio.push.framework.annotation;

import java.lang.annotation.*;

@Log
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable( Permissions.class )
public @interface Permission {
    
    /** 权限内容 */
    String value() default "";
}