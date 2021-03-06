package com.wangshuyan.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @ClassName: DateUtil 
 * @Description: æ¥æå·¥å·ç±?
 * @author: charles
 * @date: 2020å¹?2æ?28æ? ä¸å8:57:46
 */
public class DateUtil {
	
	 /**
	   * 
	   * @Title: getAgeByBirthday 
	   * @Description: æ ¹æ®åºçæ¥æç®å¹´é¾?
	   * @param date
	   * @return
	   * @return: int
	   */
	  public static int getAgeByBirthday(Date birthday) {
		  Calendar c = Calendar.getInstance();//è·åæ¥æç±?
		  int s_year =c.get(Calendar.YEAR);//è·åç³»ç»çå¹´
		  int s_month =c.get(Calendar.MONTH);//è·åç³»ç»çæ
		  int s_date =c.get(Calendar.DAY_OF_MONTH);//è·åç³»ç»çæ¥
		  c.setTime(birthday);//ç¨åºçæ¥æåå§æ¥åç±»
		  int b_year = c.get(Calendar.YEAR);//è·ååºççå¹´
		  int b_month =c.get(Calendar.MONTH);//è·ååºççæ
		  int b_date =c.get(Calendar.DAY_OF_MONTH);//è·ååºççæ¥
		  //è®¡ç®å¹´é¾
		 int age = s_year - b_year;
		 //å¦æç³»ç»æä»½å°äºb_month
		 if(s_month < b_month) {
			 age--; //å¹´é¾åå°ä¸?å²?
		 } 
		 //å¦ææä»½ç¸ç­ï¼ä½æ¯ç³»ç»çå¤©å°äºåºççå¤?
		 if(s_month == b_month &&s_date < b_date) {
			 age--; //å¹´é¾åå°ä¸?å²?
		 }
		return age;
		  
	  }
	
	/**
	 * 
	 * @Title: getEndMonth 
	 * @Description: è¿åæå®æä»½çææ«æ¥ææ¯å¦? 2020-02-28 , è¿å 2020-02-29 23:59:59
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date) {
		//è·åæ¥åç±?
		Calendar c = Calendar.getInstance();
		//ç¨ä¼ å¥çæ¥æåå§åæ¥åç±»
		c.setTime(date);
		//æ´ä½è®©æä»?+1ï¼? ååææå? -1 ç§?
		c.add(Calendar.MONTH, 1);
		Date initMonth = getInitMonth(c.getTime());//è®©æä»?+1
		c.setTime(initMonth);//ååææå?
		
		c.add(Calendar.SECOND, -1);//åå»1ç§?
		return c.getTime();
		
	}
	
	/**
	 * 
	 * @Title: getInitMonth 
	 * @Description: è¿åæå®æ¥æçæåï¼æ¯å¦ 2020-02-28 , è¿å 2020-02-01 00:00:00
	 * @param date
	 * @return
	 * @return: Date
	 */
	public  static Date  getInitMonth(Date date) {
	//è·åä¸?ä¸ªæ¥åç±»
		Calendar c = Calendar.getInstance();//è·åå½åç³»ç»æ¶é´çæ¥åç±»
		//ç¨ä¼ å¥çæ¥æååå§åæ¥åç±?
		c.setTime(date);
		//è°ç¨æ¥åç±»çç¸å³æ¹æ³
		c.set(Calendar.DAY_OF_MONTH, 1);//è®©æ¥æä¸ºå½æçç¬¬ä¸?å¤?
		c.set(Calendar.HOUR_OF_DAY, 0);//å°æ¶
		c.set(Calendar.MINUTE, 0);//åé
		c.set(Calendar.SECOND, 0);//ç§?
		
		return c.getTime();
		
	}
	
	
	
	

	/**
	 * 
	 * @Title: randomDate 
	 * @Description: TODO
	 * @param min æ?å°æ¥æ?
	 * @param max æ?å¤§æ¥æ?
	 * @return å? min åmaxä¹é´çéæºæ¥æ?
	 * @return: Date
	 */
	public  static Date randomDate(Date min,Date max) {
		// è·åæ?å°æ¥æçæ¯«ç§æ?.ä»?1970å°min çæ¯«ç§æ°
		long t1 = min.getTime();
		long t2 = max.getTime();
		
		if(t1 > t2 ) return null;
		
		double d = Math.random();  //è¿å0-1 ä¹é´çéæºå??
	    long x = (long) (d *(t2 - t1 +1 )+t1);
		return new Date(x);
		
	}
}
