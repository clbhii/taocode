package com.cl.dubbo.spring.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.dubbo.spring.provider.HelloService;

@Service("controller")
public class Controller {
	@Autowired
	private HelloService helloSerivce;

	public void add() {
		String hello = helloSerivce.sayHello("dd");
		System.out.println(hello); // 显示调用结果
	}
}
