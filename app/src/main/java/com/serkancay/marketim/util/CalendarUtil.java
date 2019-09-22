package com.serkancay.marketim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public class CalendarUtil {

    public static String getMonthName(String month) {
        SimpleDateFormat monthParse = new SimpleDateFormat("MM");
        SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM");
        try {
            return monthDisplay.format(monthParse.parse(month));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

}
