package com.cl.dubbo.zookeeper;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZooProvider {

	public static void main(String[] args) throws Exception {
        String config = ZooProvider.class.getPackage().getName().replace('.', '/') + "/zoo-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }

}
