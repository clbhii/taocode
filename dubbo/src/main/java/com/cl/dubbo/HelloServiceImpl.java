package com.cl.dubbo;

import java.util.Map;

public class HelloServiceImpl implements HelloService{

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return name + "hello";
	}

	public Map<String, Object> say(Map<String, Object> map) {
		map.put("result", "success");
		return map;
	}

	
	
}
