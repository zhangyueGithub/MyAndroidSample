package com.example.seatrend.myapplication.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by seatrend on 2019/1/11.
 */

public class StringUtils {

    public static long dateToStamp(String s){

        try {
            //yyyy-MM-dd
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            Date date = simpleDateFormat.parse(s);
            return  date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static String longToStringData(long date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA); // "yyyy-MM-dd HH:mm:ss"
            return sdf.format(new Date(date));
        } catch (Exception e) {
            return null;
        }
    }
}
