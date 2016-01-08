package com.cl.fastjson.stream;

import java.io.FileWriter;

import com.alibaba.fastjson.JSONWriter;
import com.cl.fastjson.labelfilter.VO;

public class StreamTest {

	public static void testHugeArray() throws Exception{
		JSONWriter writer = new JSONWriter(new FileWriter("/huge.json"));
		writer.startArray();
		for (int i = 0; i < 1000 * 1000; ++i) {
			writer.writeValue(new VO());
		}
		writer.endArray();
		writer.close();
	}

	public static void main(String[] args)  throws Exception{
		testHugeArray();
	}
	
}
