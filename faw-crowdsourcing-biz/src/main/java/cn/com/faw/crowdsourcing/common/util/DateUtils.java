package cn.com.faw.crowdsourcing.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期工具类
 *
 * @author gaoyang
 * @since 2015年4月13日
 */
public class DateUtils {

    /**
     * 日期格式: 年月日时分秒毫秒. 例:20150413133945139
     */
    public static final SimpleDateFormat YYYYMMDDHHMMSSSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 日期格式: 年-月-日 时:分:秒. 例:2015-04-13 13:39:45
     */
    public static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式: 年月日时分秒. 例:20150413133945
     */
    public static final SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 日期格式: 年月日时分秒. 例:201504131339
     */
    public static final SimpleDateFormat YYYYMMDDHHMM = new SimpleDateFormat("yyyyMMddHHmm");

    /**
     * 日期格式: 年月日. 例:20150415
     */
    public static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

    /**
     * 日期格式: 年-月-日. 例:2015-04-13
     */
    public static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 日期格式: 年月. 例:201504
     */
    public static final SimpleDateFormat YYYYMM = new SimpleDateFormat("yyyyMM");

    /**
     * 日期格式: 年. 例:2015
     */
    public static final SimpleDateFormat YYYY = new SimpleDateFormat("yyyy");

    /**
     * 日期格式: 月. 例:06
     */
    public static final SimpleDateFormat MM = new SimpleDateFormat("MM");

    /**
     * 日期格式: 日. 例:26
     */
    public static final SimpleDateFormat DD = new SimpleDateFormat("dd");

    /**
     * 时间格式: 时分秒. 例:131521
     */
    public static final SimpleDateFormat HHMMSS = new SimpleDateFormat("HHmmss");

    /**
     * 时间格式: 时分秒. 例:131521
     */
    public static final SimpleDateFormat HHMMSSSSS = new SimpleDateFormat("HHmmssSSS");

    /**
     * 时间格式: 时分. 例:1315
     */
    public static final SimpleDateFormat HHMM = new SimpleDateFormat("HHmm");

    /**
     * 取得当前日期时间(年月日时分秒毫秒)
     * 
     * <pre>
     * 格式为hhmmssSSS, 例:133945136
     * </pre>
     *
     * @return 精确到毫秒的当前日期时间
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getNowHMS() {
        return HHMMSSSSS.format(new Date());
    }

    /**
     * 取得当前日期时间(年月日时分秒毫秒)
     * 
     * <pre>
     * 格式为yyyyMMddhhmmssSSS, 例:20150413133945136
     * </pre>
     *
     * @return 精确到毫秒的当前日期时间
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getNow() {
        return YYYYMMDDHHMMSSSSS.format(new Date());
    }

    /**
     * 取得当前日期时间(年月日时分)
     * 
     * <pre>
     * 格式为yyyyMMddhhmm, 例:201504131339
     * </pre>
     *
     * @return 精确到秒的当前日期时间
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDatetimes() {
        return YYYYMMDDHHMM.format(new Date());
    }

    /**
     * 取得当前日期时间(年月日时分秒)
     * 
     * <pre>
     * 格式为yyyyMMddhhmmss, 例:20150413133945
     * </pre>
     *
     * @return 精确到秒的当前日期时间
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDatetime() {
        return YYYYMMDDHHMMSS.format(new Date());
    }

    /**
     * 取得当前日期时间(年月日时分秒)
     * 
     * <pre>
     * 格式为yyyy-MM-dd hh:mm:ss, 例:2015-04-13 13:39:45
     * </pre>
     *
     * @return 精确到秒的当前时间
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getNowTime() {
        return YYYY_MM_DD_HH_MM_SS.format(new Date());
    }

    /**
     * 取得当前日期(年月日)
     * 
     * @return 当前日期.格式为yyyy-MM-dd,例:2015-04-13
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getToday() {
        return YYYY_MM_DD.format(new Date());
    }

    /**
     * 取得当前日期(年月日) + N 年
     * 
     * @param date
     * @param year
     * @return
     *
     * @author gaoyang
     * @since 2016年7月4日
     */
    public static String getNextYearToday(String year) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt;
        try {
            dt = sdf.parse(getToday());
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.YEAR, 1);// 日期减1年
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return reStr;
        }
        catch (ParseException e) {
            return null;
        }
    }

    /**
     * 取得指定日期的下一年的日期
     * 
     * @param date
     * @param year
     * @return
     *
     * @author tongmeng
     * @since 2016年7月12日
     */
    public static String getNextYearByDate(SimpleDateFormat sdf, String date) {
        Date dt;
        try {
            dt = sdf.parse(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.YEAR, 1);// 日期减1年
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            return reStr;
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 取得当前日期的年月日
     * 
     * @return 当前年月日.格式为yyyyMMdd,例:20150613
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDate() {
        return YYYYMMDD.format(new Date());
    }

    /**
     * 取得YYYYMMDD格式的日期字符串中的年月日
     * 
     * <pre>
     * Datex.getDate("2015-08-19")          = "20150819"
     * Datex.getDate("2015-08-19 12:30")    = "20150819"
     * Datex.getDate("2015-08-19 12:30:21") = "20150819"
     * </pre>
     * 
     * @param date 日期字符串
     * @return 当前年月日.格式为yyyyMMdd,例:20150613
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDate(String date) {
        return getDate(date, YYYYMMDD.toPattern());
    }

    /**
     * 取得某种日期格式的指定日期字符串中的年月日
     * 
     * <pre>
     * Datex.getDate("2015-08-19", "yyyy-MM-dd")             = "20150819"
     * Datex.getDate("2015-08-19 12:30", "yyyy-MM-dd hh:mm") = "20150819"
     * </pre>
     * 
     * @param date 日期字符串
     * @param format 日期格式
     * @return 当前年月日.格式为yyyyMMdd,例:20150613
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDate(String date, String format) {
        return getDate(toDate(date, format));
    }

    /**
     * 取得指定日期的年月日
     * 
     * @param date 日期
     * @return 当前年月日.格式为yyyyMMdd,例:20150613
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDate(Date date) {
        return YYYYMMDD.format(date);
    }

    /**
     * 取得当前年
     * 
     * @return 当前年.格式为yyyy,例:2015
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYear() {
        return getYear(new Date());
    }

    /**
     * 取得YYYYMMDD格式的日期字符串中的年
     * 
     * <pre>
     * Datex.getDate("2015-08-19")          = "2015"
     * Datex.getDate("2015-08-19 12:30")    = "2015"
     * Datex.getDate("2015-08-19 12:30:21") = "2015"
     * </pre>
     * 
     * @param date 日期字符串
     * @return 当前年.格式为yyyy,例:2015
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYear(String date) {
        return getYear(date, YYYYMMDD.toPattern());
    }

    /**
     * 取得某种日期格式的指定日期字符串中的年
     * 
     * <pre>
     * Datex.getDate("2015-08-19", "yyyy-MM-dd")             = "2015"
     * Datex.getDate("2015-08-19 12:30", "yyyy-MM-dd hh:mm") = "2015"
     * </pre>
     * 
     * @param date 日期字符串
     * @param format 日期格式
     * @return 当前年.格式为yyyy,例:2015
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYear(String date, String format) {
        return getYear(toDate(date, format));
    }

    /**
     * 取得指定日期的年
     * 
     * @param date 日期
     * @return 当前年.格式为yyyy,例:2015
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYear(Date date) {
        return YYYY.format(date);
    }

    /**
     * 取得当前日期的年月
     * 
     * @return 当前年月,格式为yyyyMM, 例:201504
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYearMonth() {
        return getYearMonth(new Date());
    }

    /**
     * 取得YYYYMMDD格式的日期字符串中的年月
     * 
     * <pre>
     * Datex.getDate("2015-08-19")          = "201508"
     * Datex.getDate("2015-08-19 12:30")    = "201508"
     * Datex.getDate("2015-08-19 12:30:21") = "201508"
     * </pre>
     * 
     * @param date 日期字符串
     * @return 当前年月,格式为yyyyMM, 例:201504
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYearMonth(String date) {
        return getYearMonth(date, YYYYMMDD.toPattern());
    }

    /**
     * 取得某种日期格式的指定日期字符串中的年月
     * 
     * <pre>
     * Datex.getDate("2015-08-19", "yyyy-MM-dd")             = "201508"
     * Datex.getDate("2015-08-19 12:30", "yyyy-MM-dd hh:mm") = "201508"
     * </pre>
     * 
     * @param date 日期字符串
     * @param format 日期格式
     * @return 当前年月,格式为yyyyMM, 例:201504
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYearMonth(String date, String format) {
        return getYearMonth(toDate(date, format));
    }

    /**
     * 取得指定日期的年月
     * 
     * @param date 日期
     * @return 当前年月,格式为yyyyMM, 例:201504
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getYearMonth(Date date) {
        return YYYYMM.format(date);
    }

    /**
     * 取得当前日期的月
     * 
     * @return 当前月,格式为MM, 例:04
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getMonth() {
        return getMonth(new Date());
    }

    /**
     * 取得YYYYMMDD格式的日期字符串中的月
     * 
     * <pre>
     * Datex.getDate("2015-08-19")          = "08"
     * Datex.getDate("2015-08-19 12:30")    = "08"
     * Datex.getDate("2015-08-19 12:30:21") = "08"
     * </pre>
     * 
     * @param date 日期字符串
     * @return 当前月,格式为MM, 例:04
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getMonth(String date) {
        return getMonth(date, YYYYMMDD.toPattern());
    }

    /**
     * 取得某种日期格式的指定日期字符串中的月
     * 
     * <pre>
     * Datex.getDate("2015-08-19", "yyyy-MM-dd")             = "08"
     * Datex.getDate("2015-11-19 12:30", "yyyy-MM-dd hh:mm") = "11"
     * </pre>
     * 
     * @param date 日期字符串
     * @param format 日期格式
     * @return 当前月,格式为MM, 例:04
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getMonth(String date, String format) {
        return getMonth(toDate(date, format));
    }

    /**
     * 取得指定日期的月
     * 
     * @param date 日期
     * @return 当前月,格式为MM, 例:04
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getMonth(Date date) {
        return MM.format(date);
    }

    /**
     * 取得当前日期的日
     * 
     * @return 当前日,格式为DD, 例:26, 09
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDay() {
        return getDay(new Date());
    }

    /**
     * 取得YYYYMMDD格式的日期字符串中的日
     * 
     * <pre>
     * Datex.getDate("2015-08-19")          = "19"
     * Datex.getDate("2015-08-19 12:30")    = "19"
     * Datex.getDate("2015-08-19 12:30:21") = "19"
     * </pre>
     * 
     * @param date 日期字符串
     * @return 当前日,格式为DD, 例:26, 09
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDay(String date) {
        return getDay(date, YYYYMMDD.toPattern());
    }

    /**
     * 取得某种日期格式的指定日期字符串中的日
     * 
     * <pre>
     * Datex.getDate("2015-08-09", "yyyy-MM-dd")             = "09"
     * Datex.getDate("2015-08-19 12:30", "yyyy-MM-dd hh:mm") = "19"
     * </pre>
     * 
     * @param date 日期字符串
     * @param format 日期格式
     * @return 当前日,格式为DD, 例:26, 09
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDay(String date, String format) {
        return getDay(toDate(date, format));
    }

    /**
     * 取得指定日期的日
     * 
     * @param date 日期
     * @return 当前日,格式为DD, 例:26, 09
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getDay(Date date) {
        return DD.format(date);
    }

    /**
     * 取得当前时间(时分秒)
     * 
     * <pre>
     * 格式为hhmmss, 例:133945
     * </pre>
     *
     * @return 精确到秒的当前时间
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getTime() {
        return HHMMSS.format(new Date());
    }

    /**
     * 取得当前时间(时分)
     * 
     * <pre>
     * 格式为hhmm, 例:1339
     * </pre>
     *
     * @return 精确到分的当前时间
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static String getMinute() {
        return HHMM.format(new Date());
    }

    /**
     * 获取当前时间前一天(昨天)并转换为YYYY-MM-DD格式的日期字符串
     * 
     * @return 昨天日期字符串(YYYY-MM-DD)
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getYesteday() {
        return getYesteday(null);
    }

    /**
     * 获取当前时间前一天(昨天)并转换为指定格式的日期字符串
     *
     * <pre>
     * Datex.getYesteday(null)         = "2015-05-25"
     * Datex.getYesteday("")           = "2015-05-25"
     * Datex.getYesteday("yyyy-MM-dd") = "2015-05-25"
     * Datex.getYesteday("yyyyMMdd")   = "20150525"
     * Datex.getYesteday("yyyy|MM|dd") = "2015|05|25"
     * </pre>
     * 
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @return 指定日期的前一天(昨天)的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getYesteday(String format) {
        return getYesteday(new Date(), format);
    }

    /**
     * 获取指定时间前一天并转换为指定格式的日期字符串
     *
     * <pre>
     * Datex.getYesteday(null, "yyyyMMdd")           = java.lang.IllegalArgumentException
     * Datex.getYesteday("", "yyyyMMdd")             = java.lang.IllegalArgumentException
     * Datex.getYesteday("2099-99-99", "yyyyMMdd")   = java.lang.IllegalArgumentException
     * Datex.getYesteday("2015-05-26", null)         = "2015-05-24"
     * Datex.getYesteday("2015-05-26", "")           = "2015-05-24"
     * Datex.getYesteday("2015-05-26", "yyyy-MM-dd") = "2015-05-24"
     * Datex.getYesteday("2015-05-26", "yyyyMMdd")   = "20150524"
     * Datex.getYesteday("2015-05-26", "yyyy|MM|dd") = "2015|05|24"
     * </pre>
     * 
     * @param date 指定日期字符串
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @return 指定日期的前一日的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getYesteday(String date, String format) {
        return getYesteday(toDate(date, format), format);
    }

    /**
     * 获取指定时间前一天并转换为指定格式的日期字符串
     *
     * <pre>
     * Datex.getYesteday(null, "yyyyMMdd")         = java.lang.IllegalArgumentException
     * Datex.getYesteday(new Date(), null)         = "2015-05-24"
     * Datex.getYesteday(new Date(), "")           = "2015-05-24"
     * Datex.getYesteday(new Date(), "yyyy-MM-dd") = "2015-05-24"
     * Datex.getYesteday(new Date(), "yyyyMMdd")   = "20150524"
     * Datex.getYesteday(new Date(), "yyyy|MM|dd") = "2015|05|24"
     * </pre>
     * 
     * @param date 指定日期,为null时抛出异常
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @return 指定日期的前一日的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getYesteday(Date date, String format) {
        return getInverval(date, format, -1);
    }

    /**
     * 获取当前时间后一天(明天)并转换为YYYY-MM-DD格式的日期字符串
     * 
     * @return 明天日期字符串(YYYY-MM-DD)
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getTomorrow() {
        return getTomorrow(null);
    }

    /**
     * 获取当前时间后一天(明天)并转换为指定格式的日期字符串
     *
     * <pre>
     * Datex.getTomorrow(null)         = "2015-05-27"
     * Datex.getTomorrow("")           = "2015-05-27"
     * Datex.getTomorrow("yyyy-MM-dd") = "2015-05-27"
     * Datex.getTomorrow("yyyyMMdd")   = "20150527"
     * Datex.getTomorrow("yyyy|MM|dd") = "2015|05|27"
     * </pre>
     * 
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @return 指定日期的后一日(明天)的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getTomorrow(String format) {
        return getTomorrow(new Date(), format);
    }

    /**
     * 获取指定时间后一天并转换为指定格式的日期字符串
     *
     * <pre>
     * Datex.getTomorrow(null, "yyyyMMdd")           = java.lang.IllegalArgumentException
     * Datex.getTomorrow("", "yyyyMMdd")             = java.lang.IllegalArgumentException
     * Datex.getTomorrow("2099-99-99", "yyyyMMdd")   = java.lang.IllegalArgumentException
     * Datex.getTomorrow("2015-05-26", null)         = "2015-05-27"
     * Datex.getTomorrow("2015-05-26", "")           = "2015-05-27"
     * Datex.getTomorrow("2015-05-26", "yyyy-MM-dd") = "2015-05-27"
     * Datex.getTomorrow("2015-05-26", "yyyyMMdd")   = "20150527"
     * Datex.getTomorrow("2015-05-26", "yyyy|MM|dd") = "2015|05|27"
     * </pre>
     * 
     * @param date 指定日期字符串
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @return 指定日期的后一日的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getTomorrow(String date, String format) {
        return getTomorrow(toDate(date, format), format);
    }

    /**
     * 获取指定时间后一天并转换为指定格式的日期字符串
     *
     * <pre>
     * Datex.getTomorrow(null, "yyyyMMdd")         = java.lang.IllegalArgumentException
     * Datex.getTomorrow(new Date(), null)         = "2015-05-27"
     * Datex.getTomorrow(new Date(), "")           = "2015-05-27"
     * Datex.getTomorrow(new Date(), "yyyy-MM-dd") = "2015-05-27"
     * Datex.getTomorrow(new Date(), "yyyyMMdd")   = "20150527"
     * Datex.getTomorrow(new Date(), "yyyy|MM|dd") = "2015|05|27"
     * </pre>
     * 
     * @param date 指定日期,为null时抛出异常
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @return 指定日期的后一日的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getTomorrow(Date date, String format) {
        return getInverval(date, format, 1);
    }

    /**
     * 获取当前时间前几日或后几日并转换为YYYY-MM-DD格式的日期字符串
     *
     * <pre>
     * Datex.getInverval(1)  = "2015-05-27"
     * Datex.getInverval(3)  = "2015-05-29"
     * Datex.getInverval(-3) = "2015-05-23"
     * </pre>
     * 
     * @param amount 日期数量. 整数代表前几日,负数代表后几日
     * @return 指定日期的前几日或后几日的YYYY-MM-DD格式的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getInverval(int amount) {
        return getInverval(null, amount);
    }

    /**
     * 获取当前时间前几日或后几日并转换为固定格式的日期字符串
     *
     * <pre>
     * Datex.getInverval(null, 1)          = "2015-05-27"
     * Datex.getInverval("", 1)            = "2015-05-27"
     * Datex.getInverval("yyyyMMdd", 1)    = "20150527"
     * Datex.getInverval("yyyyMMdd", 3)    = "20150529"
     * Datex.getInverval("yyyy-MM-dd", 3)  = "2015-05-29"
     * Datex.getInverval("yyyy|MM|dd", -1) = "2015|05|25"
     * </pre>
     * 
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @param amount 日期数量. 整数代表前几日,负数代表后几日
     * @return 指定日期的前几日或后几日字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getInverval(String format, int amount) {
        return getInverval(new Date(), format, amount);
    }

    /**
     * 获取指定时间前几日或后几日并转换为固定格式的日期字符串
     *
     * <pre>
     * Datex.getInverval(null, "yyyyMMdd", 1)            = java.lang.IllegalArgumentException
     * Datex.getInverval("1234567890", "yyyyMMdd", 1)    = java.lang.IllegalArgumentException
     * Datex.getInverval("2015-05-26", null, 1)          = "2015-05-27"
     * Datex.getInverval("2015-05-26", "", 1)            = "2015-05-27"
     * Datex.getInverval("2015-05-26", "yyyy-MM-dd", 3)  = "2015-05-29"
     * Datex.getInverval("2015|05|26", "yyyy|MM|dd", -1) = "2015|05|25"
     * Datex.getInverval("2015-05-26", "yyyy-MM-dd", -3) = "2015|05|23"
     * </pre>
     * 
     * @param date 指定日期字符串, 格式为参数format中定义的格式
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @param amount 日期数量. 整数代表前几日,负数代表后几日
     * @return 指定日期的前几日或后几日字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getInverval(String date, String format, int amount) {
        return getInverval(toDate(date, format), format, amount);
    }

    /**
     * 获取指定时间前几日或后几日并转换为固定格式的日期字符串
     *
     * <pre>
     * Datex.getInverval(null, "yyyyMMdd", 1)          = java.lang.IllegalArgumentException
     * Datex.getInverval(new Date(), null, 1)          = "2015-05-27"
     * Datex.getInverval(new Date(), "", 1)            = "2015-05-27"
     * Datex.getInverval(new Date(), "yyyyMMdd", 0)    = "20150526"
     * Datex.getInverval(new Date(), "yyyyMMdd", 1)    = "20150527"
     * Datex.getInverval(new Date(), "yyyyMMdd", 3)    = "20150529"
     * Datex.getInverval(new Date(), "yyyy-MM-dd", -1) = "2015-05-25"
     * Datex.getInverval(new Date(), "yyyy|MM|dd", -3) = "2015|05|23"
     * </pre>
     * 
     * @param date 指定日期
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @param amount 日期数量. 整数代表前几日,负数代表后几日
     * @return 指定日期的前几日或后几日字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String getInverval(Date date, String format, int amount) {
        return format(addDays(date, amount), format);
    }

    /**
     * 将日志转换为YYYY-MM-DD格式的字符串
     *
     * @param date 日期
     * @return YYYY-MM-DD格式日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String format(Date date) {
        return format(date, null);
    }

    /**
     * 按照指定格式将日期转成字符串
     *
     * @param date 日期
     * @param format 格式化样式,为null时转换为YYYY-MM-DD格式
     * @return 指定样式的日期字符串
     *
     * @author zbq
     * @since 2015年5月26日
     */
    public static String format(Date date, String format) {
        format = defaultIfBlank(format, YYYY_MM_DD.toPattern());
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 日期字符串转换为日期对象
     *
     * <pre>
     * 日期字符串格式必须是yyyy-MM-dd, 例:2015-04-13
     * </pre>
     * 
     * <pre>
     * Datex.toDate(null)         = null
     * Datex.toDate("")           = null
     * Datex.toDate("2015-04")    = null
     * Datex.toDate("20150413")   = null
     * Datex.toDate("2015-4-13")  = Date
     * Datex.toDate("2015-04-13") = Date
     * </pre>
     * 
     * @param dateStr 日期字符串
     * @return 日期对象,日期不正确是返回null
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static Date toDate(String dateStr) {
        return toDate(dateStr, YYYY_MM_DD);
    }

    /**
     * 日期字符串转换为日期对象
     *
     * <pre>
     * 日期字符串格式必须是yyyy-MM-dd hh:mm:ss, 例:2015-04-13 20:22:36
     * </pre>
     * 
     * <pre>
     * Datex.toDateYMDHMS(null)                  = null
     * Datex.toDateYMDHMS("")                    = null
     * Datex.toDateYMDHMS("2015-04")             = null
     * Datex.toDateYMDHMS("20150413")            = null
     * Datex.toDateYMDHMS("2015-4-13")           = null
     * Datex.toDateYMDHMS("2015-04-13")          = null
     * Datex.toDateYMDHMS("15-04-1 1:22:3")      = Date
     * Datex.toDateYMDHMS("2015-04-1 1:22:3")    = Date
     * Datex.toDateYMDHMS("2015-4-13 12:22:23")  = Date
     * Datex.toDateYMDHMS("2015-04-13 12:22:23") = Date
     * </pre>
     * 
     * @param dateStr 日期字符串
     * @return 日期对象,日期不正确是返回null
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static Date toDateYMDHMS(String dateStr) {
        return toDate(dateStr, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 日期字符串转换为日期对象
     *
     * <pre>
     * 日期字符串格式必须是yyyyMMdd, 例:20150413
     * </pre>
     * 
     * <pre>
     * Datex.toDateYMD(null)       = null
     * Datex.toDateYMD("")         = null
     * Datex.toDateYMD("2015-04")  = null
     * Datex.toDateYMD("201504")   = null
     * Datex.toDateYMD("2015111")     = Date
     * Datex.toDateYMD("20150413") = Date
     * Datex.toDateYMD("2015413")  = Date
     * </pre>
     * 
     * @param dateStr 日期字符串
     * @return 日期对象,日期不正确是返回null
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static Date toDateYMD(String dateStr) {
        return toDate(dateStr, YYYYMMDD);
    }

    /**
     * 按照指定日期格式将日期字符串转换为日期对象
     * 
     * <pre>
     * Datex.toDate(null, "")                   = null
     * Datex.toDate("", "")                     = null
     * Datex.toDate("2015-04", "yyyy-MM-dd")    = null
     * Datex.toDate("2015-04", "yyyy-MM")       = Date
     * Datex.toDate("2015|04|15", "yyyy-MM-dd") = null
     * Datex.toDate("2015|04|15", "yyyy|MM|dd") = Date
     * </pre>
     * 
     * @param dateStr 日期字符串
     * @format 日期只付出格式
     * @return 日期对象,日期不正确或和格式不匹配是返回null
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static Date toDate(String dateStr, String format) {
        format = defaultIfBlank(format, YYYY_MM_DD.toPattern());
        return toDate(dateStr, new SimpleDateFormat(format));
    }

    /**
     * 按照指定日期格式将日期字符串转换为日期对象
     * 
     * <pre>
     * Datex.toDate(null, "")                   = null
     * Datex.toDate("", "")                     = null
     * Datex.toDate("2015-04", "yyyy-MM-dd")    = null
     * Datex.toDate("2015-04", "yyyy-MM")       = Date
     * Datex.toDate("2015|04|15", "yyyy-MM-dd") = null
     * Datex.toDate("2015|04|15", "yyyy|MM|dd") = Date
     * </pre>
     * 
     * @param dateStr 日期字符串
     * @format 日期只付出格式
     * @return 日期对象,日期不正确或和格式不匹配是返回null
     *
     * @author zbq
     * @since 2015年4月13日
     */
    public static Date toDate(String dateStr, SimpleDateFormat format) {
        try {
            return format.parse(dateStr);
        }
        catch (ParseException e) {
            throw new IllegalArgumentException("[" + dateStr + "] is not a correct date");
        }
    }

    /**
     * 取得当前时间前几年或后几年的时间
     * 
     * <pre>
     * Datex.addYears(null) = java.lang.IllegalArgumentException
     * Datex.addYears(0)    = {@code 2015-05-26}
     * Datex.addYears(1)    = {@code 2016-05-26}
     * Datex.addYears(3)    = {@code 2018-05-26}
     * Datex.addYears(-1)   = {@code 2014-05-26}
     * Datex.addYears(-3)   = {@code 2012-05-26}
     * </pre>
     * 
     * @param 时间增加或减少几年. 正数代表后几年,负数代表前几年
     * @return 后几年或前几年的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addYears(int amount) {
        return addYears(amount);
    }

    /**
     * 取得指定时间前几年或后几年的时间
     * 
     * <pre>
     * Datex.addYears(null, 1)        = java.lang.IllegalArgumentException
     * Datex.addYears({@code 2015-01-01}, 0)  = {@code 2015-01-01}
     * Datex.addYears({@code 2015-01-01}, 1)  = {@code 2016-01-01}
     * Datex.addYears({@code 2015-01-01}, 3)  = {@code 2018-01-01}
     * Datex.addYears({@code 2015-01-01}, -1) = {@code 2014-01-01}
     * Datex.addYears({@code 2015-01-01}, -3) = {@code 2012-01-01}
     * </pre>
     * 
     * @param 指定日期
     * @param 时间增加或减少几年. 正数代表后几年,负数代表前几年
     * @return 后几年或前几年的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * 取得当前时间前几月或后几月的时间
     * 
     * <pre>
     * Datex.addMonths(null) = java.lang.IllegalArgumentException
     * Datex.addMonths(0)    = {@code 2015-05-26}
     * Datex.addMonths(1)    = {@code 2015-06-26}
     * Datex.addMonths(3)    = {@code 2015-08-26}
     * Datex.addMonths(10)   = {@code 2016-03-26}
     * Datex.addMonths(-1)   = {@code 2015-04-26}
     * Datex.addMonths(-3)   = {@code 2015-02-26}
     * Datex.addMonths(-10)  = {@code 2014-07-26}
     * </pre>
     * 
     * @param 时间增加或减少几月. 正数代表后几月,负数代表前几月
     * @return 后几月或前几月的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addMonths(int amount) {
        return addMonths(amount);
    }

    /**
     * 取得指定时间前几月或后几月的时间
     * 
     * <pre>
     * Datex.addMonths(null, 1)         = java.lang.IllegalArgumentException
     * Datex.addMonths({@code 2015-10-01}, 0)   = {@code 2015-10-01}
     * Datex.addMonths({@code 2015-10-01}, 1)   = {@code 2015-11-01}
     * Datex.addMonths({@code 2015-10-01}, 3)   = {@code 2016-01-01}
     * Datex.addMonths({@code 2015-10-01}, -1)  = {@code 2015-09-01}
     * Datex.addMonths({@code 2015-10-01}, -3)  = {@code 2015-07-01}
     * Datex.addMonths({@code 2015-10-01}, -10) = {@code 2014-12-01}
     * </pre>
     * 
     * @param 指定日期
     * @param 时间增加或减少几月. 正数代表后几月,负数代表前几月
     * @return 后几月或前几月的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * 取得当前时间前几周或后几周的时间
     * 
     * <pre>
     * Datex.addMonths(null) = java.lang.IllegalArgumentException
     * Datex.addMonths(0)    = {@code 2015-05-26}
     * Datex.addMonths(1)    = {@code 2015-06-02}
     * Datex.addMonths(3)    = {@code 2015-06-16}
     * Datex.addMonths(-1)   = {@code 2015-05-19}
     * Datex.addMonths(-3)   = {@code 2015-05-05}
     * </pre>
     * 
     * @param 时间增加或减少几周. 正数代表后几周,负数代表前几周
     * @return 后几周或前几周的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addWeeks(int amount) {
        return addWeeks(amount);
    }

    /**
     * 取得指定时间前几周或后几周的时间
     * 
     * <pre>
     * Datex.addMonths(null, 1)        = java.lang.IllegalArgumentException
     * Datex.addMonths({@code 2015-10-01}, 0)  = {@code 2015-10-01}
     * Datex.addMonths({@code 2015-10-01}, 1)  = {@code 2015-10-08}
     * Datex.addMonths({@code 2015-10-01}, 3)  = {@code 2015-10-22}
     * Datex.addMonths({@code 2015-10-01}, -1) = {@code 2015-09-24}
     * Datex.addMonths({@code 2015-10-01}, -3) = {@code 2015-09-10}
     * </pre>
     * 
     * @param 指定日期
     * @param 时间增加或减少几周. 正数代表后几周,负数代表前几周
     * @return 后几周或前几周的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * 取得当前时间前几日或后几日的时间
     * 
     * <pre>
     * Datex.addMonths(null) = java.lang.IllegalArgumentException
     * Datex.addMonths(0)    = {@code 2015-05-26}
     * Datex.addMonths(1)    = {@code 2015-05-27}
     * Datex.addMonths(6)    = {@code 2015-06-01}
     * Datex.addMonths(-1)   = {@code 2015-05-24}
     * Datex.addMonths(-3)   = {@code 2015-05-22}
     * </pre>
     * 
     * @param 时间增加或减少几日. 正数代表后几日,负数代表前几日
     * @return 后几日或前几日的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addDays(final Date date, final int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 取得指定时间前几日或后几日的时间
     * 
     * <pre>
     * Datex.addMonths(null, 1)        = java.lang.IllegalArgumentException
     * Datex.addMonths({@code 2015-10-01}, 0)  = {@code 2015-10-01}
     * Datex.addMonths({@code 2015-10-01}, 1)  = {@code 2015-10-02}
     * Datex.addMonths({@code 2015-10-01}, 3)  = {@code 2015-10-24}
     * Datex.addMonths({@code 2015-10-01}, -1) = {@code 2015-09-30}
     * Datex.addMonths({@code 2015-10-01}, -3) = {@code 2015-09-28}
     * </pre>
     * 
     * @param 指定日期
     * @param 时间增加或减少几日. 正数代表后几日,负数代表前几日
     * @return 后几日或前几日的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addDays(int amount) {
        return add(new Date(), Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * 取得当前时间前几小时或后几小时的时间
     * 
     * <pre>
     * Datex.addMonths(null) = java.lang.IllegalArgumentException
     * Datex.addMonths(0)    = {@code 2015-05-26 20:46}
     * Datex.addMonths(1)    = {@code 2015-05-26 21:46}
     * Datex.addMonths(6)    = {@code 2015-05-27 02:46}
     * Datex.addMonths(-1)   = {@code 2015-05-26 19:46}
     * Datex.addMonths(-3)   = {@code 2015-05-26 17:46}
     * </pre>
     * 
     * @param 时间增加或减少几小时. 正数代表后几小时,负数代表前几小时
     * @return 后几小时或前几小时的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addHours(int amount) {
        return add(new Date(), Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 取得指定时间前几小时或后几小时的时间
     * 
     * <pre>
     * Datex.addMonths(null, 1)                 = java.lang.IllegalArgumentException
     * Datex.addMonths({@code 2015-10-01 20:14}, 0)  = {@code 2015-10-01 20:14}
     * Datex.addMonths({@code 2015-10-01 20:14}, 1)  = {@code 2015-10-01 21:14}
     * Datex.addMonths({@code 2015-10-01 20:14}, 3)  = {@code 2015-10-02 02:14}
     * Datex.addMonths({@code 2015-10-01 20:14}, -1) = {@code 2015-10-01 19:14}
     * Datex.addMonths({@code 2015-10-01 20:14}, -3) = {@code 2015-10-01 17:14}
     * </pre>
     * 
     * @param 指定日期
     * @param 时间增加或减少几小时. 正数代表后几小时,负数代表前几小时
     * @return 后几小时或前几小时的时间
     * @throws IllegalArgumentException 当日期为空时抛出
     * 
     * @author zbq
     * @since 2015年5月26日
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 在指定日期后增加或较少区间
     *
     * @param date 指定日期
     * @param calendarField 区间类型
     * @param amount 增加或减少数量,整数代表增加,负数代表较少
     * @return 设定后的时间
     *
     * @author zbq
     * @since 2015年5月26日
     */
    private static Date add(final Date date, final int calendarField, final int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * 字符串如果为null或空字符串("")或空格时转换成默认字符串
     *
     * <pre>
     * Stringx.defaultIfNull(null, "a") = "a" 
     * Stringx.defaultIfNull("", "a")   = "a" 
     * Stringx.defaultIfNull(" ", "a")  = "a" 
     * Stringx.defaultIfNull("b", "a")  = "b"
     * </pre>
     * 
     * @param str 被处理的字符串
     * @param replace 为null或空字符串("")或空格时替换的字符串
     * @return 为null或空字符串("")或空格时转换成默认字符串
     *
     * @author zbq
     * @since 2015年4月17日
     */
    public static String defaultIfBlank(String str, String replace) {
        return isBlank(str) ? replace : str;
    }

    /**
     * 判断字符串是否为空(null,""或空格)
     *
     * <pre>
     * Stringx.isEmpty(null)    = true
     * Stringx.isEmpty("")      = true
     * Stringx.isEmpty(" ")     = true
     * Stringx.isEmpty("s")     = false
     * Stringx.isEmpty("  s  ") = false
     * </pre>
     *
     * @param str 被校验的字符串,可以为null
     * @return 如果为null,""或空格返回{@code true}
     * 
     * @author zbq
     * @since 2015年4月9日
     */
    public static boolean isBlank(String str) {
        return StringUtils.isEmpty(str) || str.trim().length() == 0;
    }

    /**
     * 将时间转换为long类型
     * 
     * @param time
     * @return
     * @throws ParseException
     *
     * @author gaoyang
     * @since 2016年4月12日
     */
    public static long getDateTimestamp(String time) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(time).getTime();
        }
        catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 将时间转换为long类型(10位)
     * 
     * @param time
     * @return
     * @throws ParseException
     *
     * @author gaoyang
     * @since 2016年4月12日
     */
    public static long getDateSampTimestamp(String time) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time).getTime() / 1000;
        }
        catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 将当前时间转换为long类型
     * 
     * @return
     * @throws ParseException
     *
     * @author gaoyang
     * @since 2016年4月12日
     */
    public static long getDateNowTimestamp() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getNowTime()).getTime();
        }
        catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 比较两个日期大小
     * 
     * @param date1 日期一
     * @param date2 日期二
     * @return boolean true:日期一大于日期二
     *
     * @author gaoyang
     * @since 2016年4月20日
     */
    public static boolean compareDate(String date1, String date2) {
        try {
            Date dt1 = YYYY_MM_DD.parse(date1);
            Date dt2 = YYYY_MM_DD.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }

        return false;
    }

    /**
     * 获得两个日期相隔一共多少个月
     * 
     * @param date1
     * @param date2
     * @return
     *
     * @author weiyuan
     * @since 2016年6月16日
     */
    public static int getMonthSpace(String date1, String date2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));

            int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);

            int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

            return Math.abs(year) * 12 + Math.abs(month);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("[" + date1 + "," + date2 + "] is not a correct date");
        }

    }

    /**
     * 将当前long类型的系统时间转化成字符串类型时间
     * 
     * @param time
     * @return
     * 
     * @author tongmeng
     * @since 2016年7月12日
     */
    public static String getDateTime(long time) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return formatter.format(calendar.getTime());
    }

    /**
     * 获取当月的第一天
     * 
     * @return
     *
     * @author gaoyang
     * @since 2017年8月15日
     */
    public static String getFirstDayOfMonth() {
        // 获取当前年份、月份、日期
        Calendar cale = null;
        cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);

        return format.format(cale.getTime());
    }

    /**
     * 获取当月的最后一天
     * 
     * @return
     *
     * @author gaoyang
     * @since 2017年8月15日
     */
    public static String getLastDayOfMonth() {
        // 获取当前年份、月份、日期
        Calendar cale = null;
        cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return format.format(cale.getTime());

    }

    public static void main(String[] args) {

    }
}
