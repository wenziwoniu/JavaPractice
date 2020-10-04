package javase.test.utils;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class); 

	/**
	 * 进行日期转换时支持的日期格式
	 */
	public static final String[] parsePatterns = { "yyyy/MM/dd", "yyyy-MM-dd",
			"yyyy-M-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss",
			"yyyy-MM-dd'T'HH:mm", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy年MM月",
			"yyyy年MM月dd日","yyyyMMdd","yyyy.MM.dd" };
	
	
	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		Date dateTest = parseString("2016-03-13", "yyyy-MM-dd");
//		calendar.setTime(dateTest);
		
		System.out.println("DAY_OF_MONTH:" + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_WEEK:" + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_YEAR:" + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("DATE:" + calendar.get(Calendar.DATE));
		
		System.out.println(parseDate(new Date(), "yyyy"));
		System.out.println(getMonth(new Date()));
		Date date = parseString("2015-02-22", "yyyy-MM-dd");
		System.out.println(getMonthFirstDay(date));
		System.out.println(getYearFirstDay(date));
		System.out.println(getYearMaxDay(new Date()));
		Date addDate = addDay(new Date(), -15);
		System.out.println(parseDate(addDate, "yyyy-MM-dd"));
		Date addMonth = addMonth(new Date(), -3);
		System.out.println(parseDate(addMonth, "yyyy-MM-dd"));
		
		Date date2 = new Date();
		Date date3 = formatDate(date2, "yyyy-MM-dd");
		System.out.println(parseDate(date2, "yyyy-MM-dd HH:mm:ss.SSS"));
		System.out.println(parseDate(date3, "yyyy-MM-dd HH:mm:ss.SSS"));
		System.out.println(date2.getTime());
		System.out.println(date3.getTime());
		calendar.setTime(date2);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		System.out.println(calendar.getTimeInMillis());
		
		Date date4 = new Date();
		Date date5 = parseString("2017-06-01", "yyyy-MM-dd");
		System.out.println(monthBetweenDate(date4, date5));
//		System.out.println(countBetweenDay(date5, date4));
	}

	/**
	 * 按照指定的日期格式常量数组定义的日期格式转化日期
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateStr) throws ParseException {
		//严格解析字符串 即“2015-12-33”会出现错误
		return DateUtils.parseDateStrictly(dateStr,parsePatterns);
	}
	
	/**
	 * 功能 : 将String类型的日期解析为指定格式的Date类型的日期
	 * 开发：zwwang 2015-5-13 下午5:04:07
	 * @param date
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static Date parseString(String date, String formatType) throws ParseException {
		if (isBlank(date) || isBlank(formatType)) {
			logger.warn("日期和解析格式不能为空!");
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		return formatter.parse(formatter.format(parseDate(date)));
	}
	/**
	 * 功能 : 将日期解析为指定格式的Date类型的日期
	 * 开发：zwwang 2015-5-13 下午2:30:30
	 * @param date
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(Date date, String formatType) throws ParseException {
		if (date == null || isBlank(formatType)) {
			logger.warn("日期和解析格式不能为空!");
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
	    return formatter.parse(formatter.format(date));
	}
	
	/**
	 * 功能 : 将日期解析为指定格式的String类型值
	 * 开发：zwwang 2015-5-13 下午2:30:32
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static String parseDate(Date date, String formatType) {
		if (date == null || isBlank(formatType)) {
			logger.warn("日期和解析格式不能为空!");
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
	    return formatter.format(date);
	}
	
	
	/**
	 * 功能 : 解析String类型的日期为指定格式的String类型
	 * 开发：zwwang 2015-5-13 下午5:06:07
	 * @param date
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static String formatString(String date, String formatType) throws ParseException {
		if (isBlank(date) || isBlank(formatType)) {
			logger.warn("日期和解析格式不能为空!");
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		return formatter.format(parseDate(date));
	}
	
	/**
	 * 功能：获取当前时间 格式为yyyy-MM-dd HH:mm:ss
	 * 开发：v_wbzwwang 2016年4月11日 下午7:31:39
	 * @return
	 * @throws ParseException
	 */
	public static Date getCurrentDateTime() throws ParseException {
		Date date = new Date();
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 功能：获取当前时间 格式为yyyy-MM-dd
	 * 开发：v_wbzwwang 2016年4月11日 下午7:32:30
	 * @return
	 * @throws ParseException
	 */
	public static Date getCurrentDate() throws ParseException {
		Date date = new Date();
		return formatDate(date, "yyyy-MM-dd");
	}
	
	/**
	 * 功能：获取日期的月份
	 * 开发：v_wbzwwang 2016年3月15日 下午3:33:36
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date) {
		if (date == null) {
			logger.warn("日期不能为空!");
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("M");
		return format.format(date);
	}
	
	/**
	 * 功能：获取月份的第一天所在的日期
	 * 开发：v_wbzwwang 2016年3月15日 下午5:19:12
	 * @param date
	 * @return
	 */
	public static String getMonthFirstDay(Date date) {
		if (date == null) {
			logger.warn("日期不能为空!");
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}
	
	/**
	 * 功能：获取日期所在年份的第一天的日期
	 * 开发：v_wbzwwang 2016年3月15日 下午5:25:34
	 * @param date
	 * @return
	 */
	public static String getYearFirstDay(Date date) {
		if (date == null) {
			logger.warn("日期不能为空!");
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}
	
	/**
	 * 功能：获取日期所在年份的最后一天的日期
	 * 开发：v_wbzwwang 2016年3月15日 下午5:29:21
	 * @param date
	 * @return
	 */
	public static String getYearMaxDay(Date date) {
		if (date == null) {
			logger.warn("日期不能为空!");
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}
	
	/**
	 * 功能：获取与指定日期相隔指定天数的日期
	 * 开发：v_wbzwwang 2016年3月15日 下午5:52:43
	 * @param date
	 * @param addCount
	 * @return
	 */
	public static Date addDay(Date date, int addCount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, addCount);
		return calendar.getTime();
	}
	
	/**
	 * 功能：获取与指定日期相隔指定月份的日期
	 * 开发：v_wbzwwang 2016年3月15日 下午5:54:18
	 * @param date
	 * @param addMonth
	 * @return
	 */
	public static Date addMonth(Date date, int addMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, addMonth);
		return calendar.getTime();
	}
	
	/**
	 * 功能：获取日期之间相差的天数
	 * 开发：v_wbzwwang 2016年3月15日 下午7:32:39
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 * @throws ParseException
	 */
	public static long countBetweenDay(Date dateStart, Date dateEnd) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dateStart = format.parse(format.format(dateStart));
		dateEnd = format.parse(format.format(dateEnd));
		long millsecondOfDay = 86400000L;
		long count = (dateEnd.getTime() - dateStart.getTime())/millsecondOfDay;
		return labs(count);
		
	}
	
	/**
	 * 功能：获取日期之间相差的月份
	 * 开发：v_wbzwwang 2016年3月15日 下午8:14:57
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int monthBetweenDate(Date dateStart, Date dateEnd) {
		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(dateStart);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(dateEnd);
		int result;
		int m_begin = beginCalendar.get(Calendar.MONTH);
		int m_end = endCalendar.get(Calendar.MONTH);
		int year_begin = beginCalendar.get(Calendar.YEAR);
		int year_end = endCalendar.get(Calendar.YEAR);
		int countBetweenYear = year_end - year_begin;
		if (countBetweenYear > 0) {
			result = countBetweenYear * 12 + (m_end - m_begin);
		} else if (countBetweenYear == 0) {
			result = abs(m_end - m_begin);
		} else {
			result = -((year_end - year_begin) * 12 + (m_end - m_begin));
		}
		return result;
	}
	
	/**
	 * 功能：获取绝对值
	 * 开发：v_wbzwwang 2016年3月15日 下午7:22:35
	 * @param num
	 * @return
	 */
	public static long labs(long num) {
		return num >= 0 ? num : -num;
	}
	
	public static int abs(int num) {
		return num >= 0 ? num : -num;
	}
	
	
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	public static boolean isBlank(String str) {

		if (isEmpty(str))
			return true;

		for (char c : str.toCharArray()) {
			if (c != ' ' && c != '\t') {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
}
