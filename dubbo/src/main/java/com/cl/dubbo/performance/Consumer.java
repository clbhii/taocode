package com.cl.dubbo.performance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
	   public static void main(String[] args) throws Exception {
		   String contextFilePath = Consumer.class.getPackage().getName().replace('.', '/') + "/hello-consumer.xml";
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {contextFilePath});
	        context.start();
	 
	        HelloService helloService = (HelloService)context.getBean("helloService"); // 获取远程服务代理
//	        String hello = helloService.sayHello("world"); // 执行远程方法	 
//	        System.out.println( hello ); // 显示调用结果
	        
	        List<User> list = new ArrayList<User>();
	        for(int i = 0; i < 2000; i++) {
	        	User user = new User();
	        	user.setA1("a" + i);
	        	user.setA2("a" + i);
//	        	user.setA3("a" + i);
//	        	user.setA4("a" + i);
//	        	user.setA5("a" + i);
//	        	user.setA6("a" + i);
//	        	user.setA7("a" + i);
//	        	user.setA8("a" + i);
//	        	user.setA9("a" + i);
//	        	user.setA10("a" + i);
//	        	user.setA12("a" + i);
//	        	user.setA13("a" + i);
	        	list.add(user);
	        }
	        long being = System.currentTimeMillis();
	        List<User> userList = helloService.getUserList(list);
	        System.out.println(userList.size() + ":" + (System.currentTimeMillis()-being));
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
