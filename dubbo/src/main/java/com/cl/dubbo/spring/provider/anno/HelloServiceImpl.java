package com.cl.dubbo.spring.provider.anno;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService{
	
	@Autowired
	private User user;

	public String sayHello(String name) {
		
		return name + "hello" + user.getUserName();
	}

}
