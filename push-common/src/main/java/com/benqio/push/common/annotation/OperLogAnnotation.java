package com.benqio.push.common.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 * @author tby
 * @since
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLogAnnotation {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    String action() default "";

    /**
     * 渠道
     */
    String channel() default "1";

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的结果
     */
    boolean isSaveResponseData() default false;
}
