package com.cl.dubbo.spring.consumer.anno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.spring.provider.anno.HelloService;


public class Consumer {
	public static void main(String[] args) throws Exception {
		String config = Consumer.class.getPackage().getName().replace('.', '/') + "/spring-context.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
		context.start();

		Controller controller = (Controller) context.getBean("controller");
		controller.add();
		HelloService helloService = (HelloService) context.getBean("helloService"); // 获取远程服务代理
		String hello = helloService.sayHello("world"); // 执行远程方法
		System.out.println(hello); // 显示调用结果

	}
}
