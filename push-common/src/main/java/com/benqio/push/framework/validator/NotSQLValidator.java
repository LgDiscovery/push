package com.benqio.push.framework.validator;


import com.benqio.push.framework.validator.annotation.NotSQL;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class NotSQLValidator implements ConstraintValidator<NotSQL, String> {
    
    private static final String constraint = "'exec |execute |insert |select |delete |update |count |drop |chr |mid |master |truncate |"
            + "char |declare |sitename |net user |xp_cmdshell |like'|create |"
            + "table |from |grant |use |group_concat |column_name |"
            + "information_schema.columns|table_schema|union |where |order |by |like ";
    // String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|"
    // + "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|"
    // + "table|from|grant|use|group_concat|column_name|"
    // + "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
    // + "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";// 过滤掉的sql关键字，可以手动添加

    @Override
    public void initialize(NotSQL constraintAnnotation) {
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintContext) {
        if (null != str) {
            return this.validate(str.toLowerCase());
        }
        return true;
    }
    
    boolean validate(final String str) {
        String[] arr = constraint.split("\\|");
        for (int i = 0; i < arr.length; i++) {
            if (str.indexOf(arr[i]) >= 0) {
                log.warn("SQL injection verification is not passed：{}", str);
                return false;
            }
        }
        return true;
    }
}