package com.cl.dubbo.timeout;

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
}
