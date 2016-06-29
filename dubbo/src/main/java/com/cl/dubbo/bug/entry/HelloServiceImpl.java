package com.cl.dubbo.bug.entry;

public class HelloServiceImpl implements HelloService{

	public String sayHello(Child child) {
		System.out.println(child.getName() + ":" + child.getSuperName());
		return "dd";
	}

	
}
