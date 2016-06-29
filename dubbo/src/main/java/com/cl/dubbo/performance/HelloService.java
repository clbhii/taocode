package com.cl.dubbo.performance;

import java.util.List;

public interface HelloService {

	public String sayHello(String name);
	
	public List<User> getUserList(List<User> users);
}
