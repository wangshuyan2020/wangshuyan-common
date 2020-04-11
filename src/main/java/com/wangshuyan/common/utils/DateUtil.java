package com.wangshuyan.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @ClassName: DateUtil 
 * @Description: 日期工具�?
 * @author: charles
 * @date: 2020�?2�?28�? 上午8:57:46
 */
public class DateUtil {
	
	 /**
	   * 
	   * @Title: getAgeByBirthday 
	   * @Description: 根据出生日期算年�?
	   * @param date
	   * @return
	   * @return: int
	   */
	  public static int getAgeByBirthday(Date birthday) {
		  Calendar c = Calendar.getInstance();//获取日期�?
		  int s_year =c.get(Calendar.YEAR);//获取系统的年
		  int s_month =c.get(Calendar.MONTH);//获取系统的月
		  int s_date =c.get(Calendar.DAY_OF_MONTH);//获取系统的日
		  c.setTime(birthday);//用出生日期初始日历类
		  int b_year = c.get(Calendar.YEAR);//获取出生的年
		  int b_month =c.get(Calendar.MONTH);//获取出生的月
		  int b_date =c.get(Calendar.DAY_OF_MONTH);//获取出生的日
		  //计算年龄
		 int age = s_year - b_year;
		 //如果系统月份小于b_month
		 if(s_month < b_month) {
			 age--; //年龄减少�?�?
		 } 
		 //如果月份相等，但是系统的天小于出生的�?
		 if(s_month == b_month &&s_date < b_date) {
			 age--; //年龄减少�?�?
		 }
		return age;
		  
	  }
	
	/**
	 * 
	 * @Title: getEndMonth 
	 * @Description: 返回指定月份的月末日期比�? 2020-02-28 , 返回 2020-02-29 23:59:59
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date) {
		//获取日历�?
		Calendar c = Calendar.getInstance();
		//用传入的日期初始化日历类
		c.setTime(date);
		//整体让月�?+1�? 再变成月�? -1 �?
		c.add(Calendar.MONTH, 1);
		Date initMonth = getInitMonth(c.getTime());//让月�?+1
		c.setTime(initMonth);//再变成月�?
		
		c.add(Calendar.SECOND, -1);//减去1�?
		return c.getTime();
		
	}
	
	/**
	 * 
	 * @Title: getInitMonth 
	 * @Description: 返回指定日期的月初，比如 2020-02-28 , 返回 2020-02-01 00:00:00
	 * @param date
	 * @return
	 * @return: Date
	 */
	public  static Date  getInitMonth(Date date) {
	//获取�?个日历类
		Calendar c = Calendar.getInstance();//获取当前系统时间的日历类
		//用传入的日期再初始化日历�?
		c.setTime(date);
		//调用日历类的相关方法
		c.set(Calendar.DAY_OF_MONTH, 1);//让日期为当月的第�?�?
		c.set(Calendar.HOUR_OF_DAY, 0);//小时
		c.set(Calendar.MINUTE, 0);//分钟
		c.set(Calendar.SECOND, 0);//�?
		
		return c.getTime();
		
	}
	
	
	
	

	/**
	 * 
	 * @Title: randomDate 
	 * @Description: TODO
	 * @param min �?小日�?
	 * @param max �?大日�?
	 * @return �? min 和max之间的随机日�?
	 * @return: Date
	 */
	public  static Date randomDate(Date min,Date max) {
		// 获取�?小日期的毫秒�?.�?1970到min 的毫秒数
		long t1 = min.getTime();
		long t2 = max.getTime();
		
		if(t1 > t2 ) return null;
		
		double d = Math.random();  //返回0-1 之间的随机�??
	    long x = (long) (d *(t2 - t1 +1 )+t1);
		return new Date(x);
		
	}
}
