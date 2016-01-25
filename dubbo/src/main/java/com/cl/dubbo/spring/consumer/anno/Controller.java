package com.cl.dubbo.spring.consumer.anno;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cl.dubbo.spring.provider.anno.HelloService;


@Service("controller")
public class Controller {
	@Reference
	private HelloService helloSerivce;

	public void add() {
		String hello = helloSerivce.sayHello("dd");
		System.out.println(hello); // 显示调用结果
	}
}
