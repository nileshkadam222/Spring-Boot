package com.frankmoley.lil.learningspring.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateUtils {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromDateString(String stringDate){
        if(null != stringDate){
            try {
                return dateFormat.parse(stringDate);
            }catch (ParseException e){
                return new Date();
            }
        }
        return  new Date();
    }
}
