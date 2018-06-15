//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static final String yyyy_MM_dd_EN = "yyyy-MM-dd";
    public static final String yyyy_MM_dd_HH_mm_ss_EN = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_CN = "yyyy年MM月dd日";
    public static final String yyyy_MM_dd_HH_mm_ss_CN = "yyyy年MM月dd日HH时mm分ss秒";
    private static Map<String, DateFormat> dateFormatMap = new HashMap();

    public DateUtils() {
    }

    public static DateFormat getDateFormat(String formatStr) {
        DateFormat df = (DateFormat)dateFormatMap.get(formatStr);
        if (df == null) {
            df = new SimpleDateFormat(formatStr);
            dateFormatMap.put(formatStr, df);
        }

        return (DateFormat)df;
    }

    public static String dateToString(Date date, String dateFormatStr) {
        DateFormat format = getDateFormat(dateFormatStr);
        return date != null ? format.format(date) : null;
    }

    public static Date stringToDate(String dateTimeStr, String dateFormatStr) {
        try {
            if (dateTimeStr != null && !dateTimeStr.equals("")) {
                DateFormat format = getDateFormat(dateFormatStr);
                Date date = format.parse(dateTimeStr);
                return date;
            } else {
                return null;
            }
        } catch (ParseException var4) {
            throw new RuntimeException(var4);
        }
    }
}
