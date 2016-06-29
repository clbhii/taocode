package com.cl.dubbo.bug.entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.RpcResult;

/**
	实体字段继承覆盖bug:
	dubbo序列化和反序列化会用父类的字段覆盖子类的字段
 *  
 * @author cl
 *
 */
public class Consumer {
	   public static void main(String[] args) throws Exception {
		   String contextFilePath = Consumer.class.getPackage().getName().replace('.', '/') + "/hello-consumer.xml";
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {contextFilePath});
	        context.start();
	        try {
	        	HelloService helloService = (HelloService)context.getBean("helloService"); // 获取远程服务代理
	        	Child child = new Child();
	        	child.setName("childMy");
	        	child.setSuperName("parantMy");
		        String hello = helloService.sayHello(child); // 执行远程方法	 
		        System.out.println( hello ); // 显示调用结果
	        }catch(Exception e) {
	        	System.out.println(e.getMessage());
	        }
	        
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
