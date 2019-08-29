package com.benqio.push.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2017-05-24.
 */
public class DateUtils {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static Date getStartDayOfWeek(Date date){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
        return getStartDayOfWeek(localDateTime);
    }
    public static Date getStartDayOfWeek(TemporalAccessor date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        localDate.with(fieldISO, 1);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public  static Date LocalDateToUdate(LocalDate localDate) {

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date LodalDateTimeToDate(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static Date yearMonthToDate(int year,int month){
        LocalDate localDate = LocalDate.of(year,month,1);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date getBeginOfMonthAndYear(int year,int month){
        LocalDate localDate = LocalDate.of(year,month,1);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date getEndOfMonthAndYear(int year,int month){
        LocalDate localDate = LocalDate.of(year,month,1);
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = lastDay.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static List<Date> getMonths(int year){
        List<Date> dateList = new ArrayList<>();
        for(int i = 1;i<=12;i++){
            LocalDate localDate = LocalDate.of(year,i,1);
            ZoneId zone = ZoneId.systemDefault();
            Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
            dateList.add(Date.from(instant));
        }

        return dateList;
    }


    public static LocalDateTime UDateToLocalDateTime(Date date) {

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
       return LocalDateTime.ofInstant(instant, zone);
    }

    public static LocalDate UDateToLocalDate(Date date) {

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
       return localDateTime.toLocalDate();
    }

    public static long bwtweenDays(Date begin,Date end){
        LocalDate beginDate = UDateToLocalDate(begin);
        LocalDate endDate = UDateToLocalDate(end);
        return endDate.toEpochDay()-beginDate.toEpochDay();
    }

    public static String formatDate(Date date){
        return UDateToLocalDate(date).format(dateFormatter);
    }

    public static String formatDateTime(Date date){
        return UDateToLocalDateTime(date).format(dateFormatter);
    }
}
