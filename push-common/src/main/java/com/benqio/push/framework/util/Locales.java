package com.benqio.push.framework.util;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/**
 * 国际化类 国际化类，定义系统支持的语言，以便显示到页面的下拉框中，以下类名，方法名、原型都是以下一样
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-6-7
 * @description
 * @TODO
 */
public class Locales {
    
    private Locale current;
    
    public Map<String, Locale> getLocales() {
        Map<String, Locale> locales = new Hashtable<String, Locale>();
        /*
        ResourceBundle bundle = ResourceBundle.getBundle("messageResource", current);
        locales.put(bundle.getString("zhcn"), Locale.CHINA);
        locales.put(bundle.getString("usen"), Locale.US);
        */
        locales.put("中文", Locale.CHINA);
        locales.put("English", Locale.US);
        return locales;
    }
    
    public void setCurrent(Locale cur) {
        if (cur == null) {
            cur = Locale.getDefault();
        }
        this.current = cur;
    }
    
    public Locale getCurrent() {
        return current;
    }
}