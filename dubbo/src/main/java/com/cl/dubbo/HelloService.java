package com.cl.dubbo;

import java.util.Map;

public interface HelloService {

	public String sayHello(String name);
	
	public Map<String, Object> say(Map<String, Object> map);
	
	public void testException(String name) throws Exception;
	
	public void addUser(User user) ;
	
	public void addBadUser(BadUser badUser) ;
}
