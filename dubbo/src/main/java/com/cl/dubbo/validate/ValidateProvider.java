package com.cl.dubbo.validate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValidateProvider {

	public static void main(String[] args) throws Exception {
        String config = ValidateProvider.class.getPackage().getName().replace('.', '/') + "/validate-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }

}
