package com.cl.fastjson.map;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap();
		map.put(1, "dd");
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		Object parse = JSON.parse(jsonString);
		System.out.println(parse);
	}
}
