package com.wangshuyan.common.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @ClassName: RandomUtil 
 * @Description: 随机数工具类
 * @author: charles
 * @date: 2020�?3�?26�? 下午3:18:11
 */
public class RandomUtil {

	
	//方法1：返回min-max之间的随机整数（包含min和max值），例如返�?1-3之间的随机数，那么返�?1�?2�?3都是正确的，返回4就不对�?? (5�?)
	public static int random(int min, int max){
		Random r = new Random();
		int i = r.nextInt( max - min + 1 )+min;    // nextInt(3) 返回�?0 1 2 
		return i;
	}
	//方法2：在�?小�?�min与最大�?�max之间截取subs个不重复的随机数。例如在1-10之间�?3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了�?�应用场景：�?100篇文章中随机�?10篇文章，月�?�可能会使用到�?? (8�?)
	public static int[] subRandom (int min, int max, int subs){
		//声明数组,用来存放返回的随机数
		 int[] x =new int[subs];
	     //用来过滤重复的数�?
		 HashSet<Integer> set = new HashSet<Integer>();
		 
		 while(set.size()!=subs) {
		   int i = random(min,max);
		   set.add(i);
		 }
		 //遍历set 把�?�放入数�?
		  int k=0;
		 for (Integer value : set) {
			x[k]=value;
			k++;
		}
		return x;
	}
	//方法3：返�?1�?1-9,a-Z之间的随机字符�?? (8�?)
	public static char randomCharacter (){
		//列出�?有字�?
		String str="123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		return str.charAt(random(0, str.length()-1));
	}
	//方法4：返回参数length个字符串(5�?)，方法内部要调用randomCharacter()方法 (4�?)
	public static String randomString(int length){
		String str="";
		for (int i = 0; i < length; i++) {
			str += randomCharacter();
		}
		return str;
	}
	
}
