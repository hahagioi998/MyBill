package com.levy.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @description：日期工具类
 * @author：LevyXie
 * @create：2022-02-04 23:16
 */
public class DateUtil {
    static long millisecondsOfOneDay = 1000*60*60*24;
    static Calendar c = Calendar.getInstance();

    public static java.sql.Date util2sql(java.util.Date d){
        return  new java.sql.Date(d.getTime());
    }
    public static Date today() {
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date monthBegin() {
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.DATE, 1);
        return c.getTime();
    }

    public static Date monthEnd() {
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);

        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    public static int thisMonthTotalDay() {
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();

        return (int)((lastDayMilliSeconds - firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
    }

    public static int thisMonthLeftDay() {
        long lastDayMilliSeconds = monthEnd().getTime();
        long todayMilliSeconds = today().getTime();
        return (int)((lastDayMilliSeconds - todayMilliSeconds) / millisecondsOfOneDay) + 1;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.thisMonthLeftDay());
        System.out.println(DateUtil.thisMonthTotalDay());
    }

}
