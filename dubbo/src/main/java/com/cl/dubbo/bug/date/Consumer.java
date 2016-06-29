package com.cl.dubbo.bug.date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.spring.provider.HelloService;
/**
 * dubbo 对时间的序列化和反序列化
 * 
 * 序列化：
 * 对于
 * java.sql.Date
 * java.sql.timestamp
 * java.sql.Time
 * 先转换成java.util.Date,然后传输，
 * 反序列化
 * java.sql.Date
 * java.sql.timestamp
 * java.sql.Time
 * 先转换成 java.util.Date,然后转为对于的时间类
 * 但是
 * java.sql.Date
 * java.sql.Time
 * 没做非空判断，会报空指针异常
 * 
 * @author cl
 *
 */
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
