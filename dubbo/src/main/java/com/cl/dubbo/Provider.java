package com.cl.dubbo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) {
		String contextFilePath = "remote-provider.xml";
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
