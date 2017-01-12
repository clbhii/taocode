package com.cl.dubbo.payload;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * payload 默认8m,
 * <dubbo:protocol/>
 * <dubbo:provider/>
 * 
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
