package com.cl.dubbo.performance;

import java.util.List;

public class HelloServiceImpl implements HelloService{

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name + "hello";
	}

	public List<User> getUserList(List<User> users) {
		return users;
	}
	
	
}
