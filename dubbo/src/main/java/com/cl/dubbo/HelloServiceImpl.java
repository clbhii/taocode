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

	public void testException(String name) throws Exception{
		throw new Exception("fail");
	}

	public void addUser(User user) {
		System.out.println(user);
	}

	public void addBadUser(BadUser badUser) {
		System.out.println(badUser);
	}
	
	
}
