package com.cl.dubbo.exception;

import com.cl.dubbo.exception.my.CLSException;

public class HelloServiceImpl implements HelloService{

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		throw new CLSException("哈哈");
		//return name + "hello";
	}
}
