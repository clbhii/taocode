package com.cl.dubbo.cache;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheProvider {

	public static void main(String[] args) throws Exception {
        String config = CacheProvider.class.getPackage().getName().replace('.', '/') + "/cache-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }

}
