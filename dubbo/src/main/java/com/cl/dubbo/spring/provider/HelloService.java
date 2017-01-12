package com.cl.dubbo.spring.provider;

public interface HelloService {

	public String sayHello(String name);
	
	public String sayHello(Integer age);
	public String sayHello(String name, String name1);
}
