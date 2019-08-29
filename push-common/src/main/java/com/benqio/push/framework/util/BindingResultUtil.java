package com.benqio.push.framework.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;

public class BindingResultUtil {
    
    public static HashMap<String, String> errors(BindingResult result) {
        HashMap<String, String> errors = new HashMap<String, String>();
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }
}