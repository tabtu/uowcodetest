package uow.codetest.tab.design.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private final static long minute = 60 * 1000;// 1 Minute
    private final static long hour = 60 * minute;// 1 Hour
    private final static long day = 24 * hour;// 1 Day
    private final static long month = 31 * day;// Month
    private final static long year = 12 * month;// Year

    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmssSSS";

    public static String getDateSequence() {
        return new SimpleDateFormat(YYYYMMDDHHMMSS).format(new Date());
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String getTimeFormatText(Long date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date;
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "years ago";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "months ago";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "days ago";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "hours ago";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "minutes ago";
        }
        return "recently";
    }

    public static long getDayBegin(long timestamp) {
        String format = "yyyy-MM-DD";
        String toDayString = new SimpleDateFormat(format).format(new Date(timestamp));
        Date toDay = null;
        try {
            toDay = org.apache.commons.lang.time.DateUtils.parseDate(toDayString, new String[]{format});

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toDay.getTime();
    }

    public static long getLastMonthTime() {
        return getDayBegin(getCurrentTime())-86400000l*30;
    }

}
