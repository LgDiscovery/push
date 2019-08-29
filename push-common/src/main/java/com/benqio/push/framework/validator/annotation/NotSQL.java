package com.benqio.push.framework.validator.annotation;


import com.benqio.push.framework.validator.NotSQLValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NotSQLValidator.class)
@Documented
public @interface NotSQL {
    
    Class<?>[]groups() default {};
    
    String message() default "存在SQL注入关键字";
//    String message() default "{javax.validation.constraints.SqlInjection.message}";
    
    Class<? extends Payload>[]payload() default {};
    
}