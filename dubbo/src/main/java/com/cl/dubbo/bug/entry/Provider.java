package com.cl.dubbo.bug.entry;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.validate.ValidateProvider;

/**
 * timout优先级
 * -D > xml > properties
 * xml中
 * consumer>provider
 * method>class>默认的
 * 
 * @author cl
 *
 */
public class Provider {

	public static void main(String[] args) {
		String contextFilePath = Provider.class.getPackage().getName().replace('.', '/') + "/hello-provider.xml";
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext(contextFilePath);
		context.start();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 按任意键退出
	}
}
