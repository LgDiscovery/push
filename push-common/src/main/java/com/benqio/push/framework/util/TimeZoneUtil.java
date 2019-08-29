package com.benqio.push.framework.util;

import java.util.Date;
import java.util.TimeZone;

/**
 * 不同时区对应的时间处理工具类
 * 
 * @author jinyifeng5969@163.com
 * @since 2017年8月18日 下午8:27:29
 * @version v1.0.0
 *
 */
public class TimeZoneUtil {
    
    /**
     * 系统当前时区是否为东八区
     * 
     * @return
     */
    public static boolean isInEast8() {
        return TimeZone.getDefault() == TimeZone.getTimeZone("GMT+08");
    }
    
    /**
     * 根据不同时区，转换时间
     * 
     * @param time
     * @return
     */
    public static Date transformTime(Date date, TimeZone oldZone, TimeZone newZone) {
        if (date != null) {
            long time = date.getTime();
            int timeOffset = oldZone.getOffset(time) - newZone.getOffset(time);
            date = new Date(time - timeOffset);
        }
        return date;
    }
}