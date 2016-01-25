package com.cl.dubbo.cls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.HelloService;

public class CustomerTest {
	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"cls-consumer.xml"});
        context.start();
 
        HelloService helloService = (HelloService)context.getBean("helloService"); // 获取远程服务代理
        String hello = helloService.sayHello("world"); // 执行远程方法	 
        System.out.println( hello ); // 显示调用结果
       
    }
}
