package com.wangshuyan.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: StreamUtil 
 * @Description: 流处理
 * @author: charles
 * @date: 
 */
public class StreamUtil {
	
	//读取InputStream 放入集合
    public static List<String> read(InputStream InputStream) throws IOException{
    	
    	//声明集合
    	List<String> list = new ArrayList<String>();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(InputStream));
    	String line="";
		while((line=reader.readLine())!=null) {
			list.add(line);
		}
		return list;
	}
	//根据文件的地�?读取文件放入 集合�?
	public static List<String> read(String filePath) throws IOException{
		//声明集合
         FileInputStream inputStream = new FileInputStream(filePath);
		return read(inputStream);
		
	}
	
	//读取文件内容放入集合
	
	public static List<String> read(File file) throws IOException{
		FileInputStream inputStream = new FileInputStream(file);
	    return read(inputStream);
		
	}

}
