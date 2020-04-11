package com.wangshuyan.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testRead() throws IOException {
		
		//InputStream in = this.getClass().getResourceAsStream("/data2.txt");
	    List<String> list = StreamUtil.read(new File("e:\\data1.txt"));
		//List<String> list = StreamUtil.read(in);
	    
	    for (String string : list) {
			System.out.println(string);
		}
	}

}
