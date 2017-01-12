package com.cl.dubbo.spring.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("helloService")
public class HelloServiceImpl implements HelloService{
	
	@Autowired
	private User user;

	public String sayHello(String name) {
		
		return name + "hello" + user.getUserName();
	}
	
	
	public String sayHello(String name, String name1) {
		return name1 + "hello" + user.getUserName();
	}


	@Override
	public String sayHello(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
