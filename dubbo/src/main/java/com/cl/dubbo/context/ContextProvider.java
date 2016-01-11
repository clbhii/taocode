package com.cl.dubbo.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextProvider {

	public static void main(String[] args) throws Exception {
        String config = ContextProvider.class.getPackage().getName().replace('.', '/') + "/context-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }

}
