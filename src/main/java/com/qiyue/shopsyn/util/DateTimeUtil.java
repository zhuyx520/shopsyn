package com.qiyue.shopsyn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * 日期工具类
 * 
 * @author zhangwei 2014/10/14
 */
public final class DateTimeUtil {

	public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMddHHmmss2 = "yyyyMMddHHmmss";
	public static final String yyyyMMddHHmm = "yyyyMMddHHmm";
	public static final String yyyyMMddHHmm2 = "yyyy-MM-dd HH:mm";
	public static final String yyyyMMddHH = "yyyyMMddHH";
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String yyyyMMdd2 = "yyyyMMdd";
	public static final String yyyyMM = "yyyyMM";
	public static final String yyyy = "yyyy";
	public static final String HHMMSS = "HHmmss";
	public static final String HHMM = "HH:mm";
	public static final int DAYMIS = 1000 * 60 * 60 * 24;

	// private static Log log = LogFactory.getLog(DateTimeUtil.class);

	private DateTimeUtil() {
	}

	public static final String getFormatTime(String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(new GregorianCalendar().getTime());
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addHour(Date date, int hours) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addSecond(Date date, int second) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addMinuteV2(Date date, int minute) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addMonths(Date date, int months) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	public static Date StringToDate(String strDate, String pattern) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDaysBetweenV2(Date date1, Date date2) {
		Calendar d1 = Calendar.getInstance();
		d1.setTime(date1);
		Calendar d2 = Calendar.getInstance();
		d2.setTime(date2);
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);

			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDaysBetween(Date date1, Date date2) {
		Calendar d1 = Calendar.getInstance();
		d1.setTime(date1);
		Calendar d2 = Calendar.getInstance();
		d2.setTime(date2);
		if (d1.after(d2)) {
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);

			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	public static int compareDate(String date1, String date2, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return compareDate(sdf.parse(date1), sdf.parse(date2));
	}

	public static int compareDate(String date1, String date2, SimpleDateFormat sdf) throws ParseException {
		return compareDate(sdf.parse(date1), sdf.parse(date2));
	}

	/**
	 * 大于0 date1>date2 0表示相等 小于0date1<date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		if (null == date1) {
			if (null == date2) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (null == date2) {
				return -1;
			} else {
				return date1.compareTo(date2);
			}
		}
	}

	public static Date getCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		return calendar.getTime();
	}

	public static Date getCurrentDate() {
		Calendar calendar = new GregorianCalendar();
		Date time = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String s = format.format(time);
		try {
			return format.parse(s);
		} catch (Exception e) {
			return null;
		}
	}
	
	//获得年和月份
	public static String getCurrentYearAndMonth() {
		Calendar calendar = new GregorianCalendar();
		Date time = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String s = format.format(time);
		return s;
	}

	public static int getCurrentYear() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.MONTH) + 1;
	}

	public static String getWeekOfDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		switch (week) {
		case 1:
			return "星期日";
		case 2:
			return "星期一";
		case 3:
			return "星期二";
		case 4:
			return "星期三";
		case 5:
			return "星期四";
		case 6:
			return "星期五";
		case 7:
			return "星期六";
		default:
			break;
		}
		return "Unknown";
	}

	public static String formatTime(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public static Date toTime(String time, String pattern) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(time);
	}

	public static Date getFirstDayOfCurrentWeek() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.getActualMinimum(Calendar.DAY_OF_WEEK);
		calendar.set(Calendar.DAY_OF_WEEK, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getFirstDayOfCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getFirstDayOfCurrentSeason() {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(new Date());
		int curMonth = cDay.get(Calendar.MONTH);
		if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
			cDay.set(Calendar.MONTH, Calendar.JANUARY);
		}
		if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
			cDay.set(Calendar.MONTH, Calendar.APRIL);
		}
		if (curMonth >= Calendar.JULY && curMonth <= Calendar.SEPTEMBER) {
			cDay.set(Calendar.MONTH, Calendar.JULY);
		}
		if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {
			cDay.set(Calendar.MONTH, Calendar.OCTOBER);
		}
		cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cDay.getTime();
	}

	public static Date getLastDayOfCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getFirstDayOfDate(String date) throws Exception {
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		String nowDate = year + "-" + month + "-" + 1;
		return toTime(nowDate, "yyyy-MM-dd");
	}

	public static Date getLastDayOfDate(String date) throws Exception {
		String[] dates = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		int maxDate = cal.getActualMaximum(Calendar.DATE);
		String nowDate = year + "-" + month + "-" + maxDate;
		return toTime(nowDate, "yyyy-MM-dd");
	}

	/**
	 * 获取指定日期的星期信息
	 * 
	 * @author Nany 2015年2月2日下午2:40:02
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		String[] weeks = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}

	/**
	 * 获取两时间点相差的秒数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Integer getSecondsBetween(Date startDate, Date endDate, int offset) {
		long v = endDate.getTime() - startDate.getTime() + offset;
		long interval = (v / 1000);
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 获取指定时间到当前时间相差的秒数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Integer getCurrentTimeToEndDateSecondsNew(Date endDate) {
		Date currentTime = DateTimeUtil.getCurrentTime();
		long v = endDate.getTime() - currentTime.getTime();
		if (v < 0) {
			return 0;
		} else {
			long interval = (v / 1000);
			return Integer.valueOf(String.valueOf(interval));
		}
	}

	public static Date getLastDayTimeOfCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		// calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取当前月份的最后一秒到当前时间的间隔
	 * 
	 * @return
	 */
	public static Integer getMonthLastTimeSeconds(int offset) {
		Date dateTime = getCurrentTime();
		Date date = getLastDayTimeOfCurrentMonth();
		long v = date.getTime() - dateTime.getTime() + offset;
		long interval = v / 1000;
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 获取当前日期最后一天到现在的秒数
	 * 
	 * @return
	 */
	public static Integer getDayLastTimeSeconds(int offset) {
		Date date = addDays(DateTimeUtil.getCurrentDate(), +1);
		Date localTime = getCurrentTime();
		long v = date.getTime() - localTime.getTime() + offset;
		long interval = v / 1000;
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 获取当前日期最后一天到现在的秒数
	 * 
	 * @return
	 */
	public static Integer getDayLastTimeSeconds(int offset, Date endTime) {
		Date localTime = getCurrentTime();
		long v = endTime.getTime() - localTime.getTime() + offset;
		long interval = v / 1000;
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 获取当前日期最后一天到现在的秒数
	 * 
	 * @return
	 */
	public static Integer getMinuteLastTimeSeconds() {
		Date date = addMinuteV2(DateTimeUtil.getCurrentTime(), +1);
		Date localTime = getCurrentTime();
		long v = date.getTime() - localTime.getTime();
		long interval = v / 1000;
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 获取当前日期最后一天到现在的秒数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Integer getNextDayLastTimeSeconds(int offset) {
		Date date = addDays(DateTimeUtil.getCurrentDate(), +2);
		Date localTime = getCurrentTime();
		long v = date.getTime() - localTime.getTime() + offset;
		long interval = v / 1000;
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 获取当前日期最后一天到现在的秒数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Integer getNextDayLastTimeSeconds2(Date localTime, int offset) {
		Date date = addDays(localTime, +2); // 失效时所在的时间点
		Date timeDate = DateTimeUtil.getCurrentTime(); // 当前时间
		long v = date.getTime() - timeDate.getTime() + offset; // 失效时间减去当前时间，为剩余失效时间
		long interval = v / 1000;
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 获取当前日期最后一天到现在的秒数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Integer getNextMinuteastTimeSeconds() {
		Date localTime = DateTimeUtil.getCurrentTime();
		Date date = addMinute(localTime, +1); // 失效时所在的时间点
		Date timeDate = DateTimeUtil.getCurrentTime(); // 当前时间
		long v = date.getTime() - timeDate.getTime(); // 失效时间减去当前时间，为剩余失效时间
		long interval = v / 1000;
		return Integer.valueOf(String.valueOf(interval));
	}

	/**
	 * 两个日期是否相等
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isEqual(Date date1, Date date2) {
		boolean flag = false;
		String date = DateTimeUtil.formatTime(date1, DateTimeUtil.yyyyMMdd2);
		String cDate = DateTimeUtil.formatTime(date2, DateTimeUtil.yyyyMMdd2);
		if (date.equals(cDate)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断两个日期是否为同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {

		return formatTime(date1, yyyyMMdd2).equals(formatTime(date2, yyyyMMdd2));
	}

	/**
	 * 判断两个日期是否在同一月
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameMonth(Date date1, Date date2) {

		return formatTime(date1, yyyyMM).equals(formatTime(date2, yyyyMM));
	}

	/**
	 * 获取当前日期的最后一秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastSecondsOfTheDay(Date date) {

		long curMillisecond = date.getTime();
		long resultMis = curMillisecond + (DAYMIS - 1);
		return new Date(resultMis);
	}

	/**
	 * 返回给定日期的前days[-]天或者后days[+]天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDaysOnly(Date date, int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		// calendar.set(Calendar.HOUR_OF_DAY, 0);
		// calendar.set(Calendar.MINUTE, 0);
		// calendar.set(Calendar.SECOND, 0);
		// calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static Date addMonthsOnly(Date date, int months) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		// calendar.set(Calendar.HOUR_OF_DAY, 0);
		// calendar.set(Calendar.MINUTE, 0);
		// calendar.set(Calendar.SECOND, 0);
		// calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	public static Date getDayLastTime(Date start) {
		Calendar ca = Calendar.getInstance();

		ca.setTime(start);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.MILLISECOND, 0);

		return new Date(ca.getTimeInMillis() + 86400000 - 1);
	}

	public static Date getLastDayOfMonth(Date start) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(start);
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getLastDayOfYear(Date start) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(start);

		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getExpireDate(Date start, Integer expireType, String expireData) {
		if (null == expireType) {
			return null;
		}
		if (expireData == null) {
			return null;
		}
		if (start == null) {
			start = getCurrentTime();
		}
		switch (expireType) {
		case GlobalConst.ExpireType.NO_EXPIRE:
			return start;
		case GlobalConst.ExpireType.MINUTE:
			return new Date(start.getTime() + Integer.parseInt(expireData) * 60000L);
		case GlobalConst.ExpireType.DAY:
			return addDaysOnly(start, Integer.parseInt(expireData));
		case GlobalConst.ExpireType.MONTH:
			return addMonthsOnly(start, Integer.parseInt(expireData));
		case GlobalConst.ExpireType.YEAR:
			return addMonthsOnly(start, Integer.parseInt(expireData) * 12);
		case GlobalConst.ExpireType.END_OF_DAY:
			return addDaysOnly(getDayLastTime(start), Integer.parseInt(expireData));
		case GlobalConst.ExpireType.END_OF_MONTH:
			return addMonthsOnly(getLastDayOfMonth(start), Integer.parseInt(expireData));
		case GlobalConst.ExpireType.END_OF_YEAR:
			return addMonthsOnly(getLastDayOfYear(start), Integer.parseInt(expireData) * 12);
		case GlobalConst.ExpireType.DIRECT:
			return StringToDate(expireData, yyyyMMddHHmmss);

		}
		return null;
	}

	public static Date getLastTimeOfDay(int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		// calendar.set(Calendar.MILLISECOND,999);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static Set<String> getCacheDateSet() {
		Date date = DateTimeUtil.getCurrentDate();
		Set<String> dateSet = new HashSet<String>();
		dateSet.add(DateTimeUtil.formatTime(date, DateTimeUtil.yyyyMMdd));
		dateSet.add(DateTimeUtil.formatTime(DateTimeUtil.addDays(date, -1), DateTimeUtil.yyyyMMdd));
		return dateSet;
	}

	public static Date getPreTimeOfDay(int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		// calendar.set(Calendar.MILLISECOND,999);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	/**
	 * 当前日期是否在开始时间与结束时间之内
	 * 
	 * @return
	 */
	public static boolean isInclude(Date startTime, Date endTime, Date inDateTime) {
		long start = startTime.getTime();
		long end = endTime.getTime();
		long localTime = inDateTime.getTime();
		if (localTime >= start && localTime <= end) {
			return true;
		} else {
			return false;
		}
	}

	
	public static Date[] getHourStartAndEnd(Date currentTime) throws Exception {
		Calendar cale = Calendar.getInstance();
		cale.setTime(currentTime);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		Date start = cale.getTime();
		
		cale = Calendar.getInstance();
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		Date end = cale.getTime();
		Date[] dateArr = new Date[]{start,end};
		return dateArr;
	}
	
	
	public static Date[] getDayStartAndEnd(Date currentTime) throws Exception {
		Calendar cale = Calendar.getInstance();
		cale.setTime(currentTime);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		Date start = cale.getTime();
		
		cale = Calendar.getInstance();
		cale.set(Calendar.HOUR_OF_DAY, 23);
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		Date end = cale.getTime();
		Date[] dateArr = new Date[]{start,end};
		return dateArr;
	}

	public static Date[] getMonthStartAndEnd(Date currentTime) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(currentTime);
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		Date start = cale.getTime();
		
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		cale.set(Calendar.HOUR_OF_DAY, 23);
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		Date end = cale.getTime();
		Date[] dateArr = new Date[]{start,end};
		return dateArr;
		
	}

	public static void main(String[] args) throws Exception {
		Date dateTime = DateTimeUtil.getCurrentTime();
		Date[] dateArr = DateTimeUtil.getMonthStartAndEnd(dateTime);
		//Date[] dateArr = DateTimeUtil.getDayStartAndEnd(dateTime);
		//Date[] dateArr = DateTimeUtil.getHourStartAndEnd(dateTime);
		for (Date date : dateArr) {
			String lastday = DateTimeUtil.formatTime(date, DateTimeUtil.yyyyMMddHHmmss);
			System.out.println(lastday);
		}
		String month = DateTimeUtil.getCurrentYearAndMonth();
		System.out.println("当前月份"+month);
		
	}
	public static int getCurrentWeek() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static int getWeekOfYear(Date date) { 
		 Calendar c = new GregorianCalendar(); 
		 c.setFirstDayOfWeek(Calendar.MONDAY); 
		 c.setMinimalDaysInFirstWeek(7); 
		 c.setTime (date);
		 return c.get(Calendar.WEEK_OF_YEAR); 
	}
}
