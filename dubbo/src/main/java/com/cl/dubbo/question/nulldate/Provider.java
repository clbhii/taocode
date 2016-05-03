package com.cl.dubbo.question.nulldate;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.cache.CacheProvider;

public class Provider {

	public static void main(String[] args) {
		String config = Provider.class.getPackage().getName().replace('.', '/') + "/nulldate-provider.xml";
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext(config);
		context.start();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 按任意键退出
	}
}
