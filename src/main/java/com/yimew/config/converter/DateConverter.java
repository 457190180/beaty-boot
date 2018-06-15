package com.yimew.config.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * yy-MM-dd hh:mm字符转日
 * @author lxy
 *
 */
public class DateConverter implements Converter<String, Date>{

    public Date convert(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
        	
        }
        return null;
    }

}
