package com.cl.dubbo.question.nulldate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.spring.provider.HelloService;

public class Consumer {
	public static void main(String[] args) throws Exception {
		String config = Consumer.class.getPackage().getName().replace('.', '/') + "/nulldate-consumer.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
		context.start();

		NullDateService nullDateService = (NullDateService) context.getBean("nullDateService");
		NullDate nullDate = new NullDate();
		nullDate.setName("dd");
		nullDateService.question(nullDate);
		nullDate.setDate(new java.sql.Date(System.currentTimeMillis()));
		nullDateService.question(nullDate);
	}
}
