package com.cl.dubbo.callback;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.dubbo.cache.CacheProvider;

public class CallbackConsumer {
	   public static void main(String[] args) throws Exception {
		   String config = CallbackConsumer.class.getPackage().getName().replace('.', '/') + "/callback-consumer.xml";
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
	        context.start();
	        CallbackService callbackService = (CallbackService) context.getBean("callbackService");
	        
	        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener(){
	            public void changed(String msg) {
	                System.out.println("callback1:" + msg);
	            }
	        });
	       
	        try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 按任意键退出
	    }
}
