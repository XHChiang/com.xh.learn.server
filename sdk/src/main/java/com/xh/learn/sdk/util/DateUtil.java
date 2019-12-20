package com.xh.learn.sdk.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class DateUtil {
	public static final String HHMMSS = "HH:mm:ss";

	public static final String YYYYMMDD = "yyyy-MM-dd";
	public static final String YYYYMMDD2 = "yyyy/MM/dd";
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS2 = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 私有构造方法，禁止实例化
	 */
	private DateUtil() {
		super();
	}

	/**
	 * 年月日时分秒加减
	 * 
	 * @param date
	 * @param params
	 * @return
	 */
	public static Date addYMDHms(Date date, Map<Integer, Integer> params) {
		Date rdate = null;
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);

			// 年
			if (params.get(Calendar.YEAR) != null) {
				c.add(Calendar.YEAR, params.get(Calendar.YEAR));
			}
			// 月
			if (params.get(Calendar.MONTH) != null) {
				c.add(Calendar.MONTH, params.get(Calendar.MONTH));
			}
			// 日
			if (params.get(Calendar.DAY_OF_MONTH) != null) {
				c.add(Calendar.DAY_OF_MONTH, params.get(Calendar.DAY_OF_MONTH));
			}
			// 时
			if (params.get(Calendar.HOUR_OF_DAY) != null) {
				c.add(Calendar.HOUR_OF_DAY, params.get(Calendar.HOUR_OF_DAY));
			}
			// 分
			if (params.get(Calendar.MINUTE) != null) {
				c.add(Calendar.MINUTE, params.get(Calendar.MINUTE));
			}
			// 秒
			if (params.get(Calendar.SECOND) != null) {
				c.add(Calendar.SECOND, params.get(Calendar.SECOND));
			}
			// 周
			if (params.get(Calendar.WEEK_OF_MONTH) != null) {
				c.add(Calendar.WEEK_OF_MONTH, params.get(Calendar.WEEK_OF_MONTH));
			}

			rdate = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rdate;
	}

	/**
	 * Date转换为Pattern格式时间
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		String dateStr = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			dateStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;
	}

	/**
	 * 删除时分秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date delHHmmss(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取本月的开始时间
	 * 
	 * @return
	 */
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}

	/**
	 * 获取本周的开始时间
	 * 
	 * @return
	 */
	public static Date getBeginDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}

	/**
	 * 获取本年的开始时间
	 * 
	 * @return
	 */
	public static Date getBeginDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);

		return getDayStartTime(cal.getTime());
	}

	/**
	 * 获取某个日期的结束时间
	 * 
	 * @param d
	 * @return
	 */
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * 获取某个日期的开始时间
	 * 
	 * @param d
	 * @return
	 */
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * 获取本月的结束时间
	 * 
	 * @return
	 */
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}

	/**
	 * 获取本周的结束时间
	 * 
	 * @return
	 */
	public static Date getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}

	/**
	 * 获取本年的结束时间
	 * 
	 * @return
	 */
	public static java.util.Date getEndDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 31);
		return getDayEndTime(cal.getTime());
	}

	/**
	 * 获取当天的结束时间
	 * 
	 * @return
	 */
	public static Date getEndTimeOfDay() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 59);
		return cal.getTime();
	}

	/**
	 * 获取本月是哪一月
	 * 
	 * @return
	 */
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

	/**
	 * 获取今年是哪一年
	 * 
	 * @return
	 */
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

	/**
	 * 获取当天的开始时间
	 * 
	 * @return
	 */
	public static Date getStratTimeOfDay() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 日期比较：d1是否等于d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Boolean isEqual(Date d1, Date d2) {
		Boolean isGt = null;
		try {
			Long ld1 = d1.getTime();
			Long ld2 = d2.getTime();
			if (ld1.equals(ld2)) {
				isGt = true;
			} else {
				isGt = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isGt;
	}

	/**
	 * 日期比较：d1是否大于d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Boolean isGt(Date d1, Date d2) {
		Boolean isGt = null;
		try {
			Long ld1 = d1.getTime();
			Long ld2 = d2.getTime();
			if (ld1 > ld2) {
				isGt = true;
			} else {
				isGt = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isGt;
	}

	/**
	 * 日期比较：d1是否大于等于d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Boolean isGte(Date d1, Date d2) {
		Boolean isGt = null;
		try {
			Long ld1 = d1.getTime();
			Long ld2 = d2.getTime();
			if (ld1 >= ld2) {
				isGt = true;
			} else {
				isGt = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isGt;
	}

	public static void main(String[] args) {
		System.out.println(stringToDate("2017-10-08 13:14:15", YYYYMMDDHHMMSS).getTime());
	}

	/**
	 * String转换为Pattern格式时间
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String dateStr, String pattern) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
