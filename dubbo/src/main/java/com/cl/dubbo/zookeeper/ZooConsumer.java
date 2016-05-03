package com.cl.dubbo.zookeeper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZooConsumer {

    public static void main(String[] args) throws Exception {
        String config = ZooConsumer.class.getPackage().getName().replace('.', '/') + "/zoo-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        ZooService zooService = (ZooService)context.getBean("zooService");
//        String result = zooService.sayHello("1");
//        System.out.println(result);
//        zooService.addBadUser(new BadUser());
        
        Map<String, Object> map = new HashMap<String, Object> ();
		for(int i = 0; i < 100; i++) {
			map.put("a" + i , "ff" + i);
		}
        long begin = System.currentTimeMillis();
        zooService.addA(new A());
        System.out.println("cost:" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        zooService.addMap(map);
        System.out.println("cost:" + (System.currentTimeMillis() - begin));

    }
}
