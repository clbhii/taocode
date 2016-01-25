package com.cl.dubbo.zookeeper;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.BadUser;

public class ZooConsumer {

    public static void main(String[] args) throws Exception {
        String config = ZooConsumer.class.getPackage().getName().replace('.', '/') + "/zoo-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        ZooService zooService = (ZooService)context.getBean("zooService");
//        String result = zooService.sayHello("1");
//        System.out.println(result);
        zooService.addBadUser(new BadUser());


    }
}
