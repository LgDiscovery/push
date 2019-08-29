package com.benqio.push.framework.util;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

@SuppressWarnings("serial")
public class PinyinSimpleComparator implements Comparator<String>, Serializable {
    
    public int compare(String o1, String o2) {
        return Collator.getInstance(Locale.CHINESE).compare(o1, o2);
    }
}