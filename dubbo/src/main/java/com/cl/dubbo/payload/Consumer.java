package com.cl.dubbo.payload;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
	   public static void main(String[] args) throws Exception {
		   String contextFilePath = Consumer.class.getPackage().getName().replace('.', '/') + "/hello-consumer.xml";
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {contextFilePath});
	        context.start();
	 
	        HelloService helloService = (HelloService)context.getBean("helloService"); // 获取远程服务代理
	        String hello = helloService.sayHello("world"); // 执行远程方法	 
	        System.out.println( hello ); // 显示调用结果
//	        Map<String, Object> map = new HashMap<String, Object>();
//	        map.put("request", "dd");
//	        Map<String, Object> map1 = helloService.say(map);
//	        System.out.println(map1);
//	        
//	        helloService.testException("dd");
	        
	        //如果没有序列化会报错
//	        helloService.addUser(new User());
	        //helloService.addBadUser(new BadUser());
	    }
}
