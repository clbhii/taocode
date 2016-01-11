package com.cl.dubbo.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;

public class ContextConsumer {

    public static void main(String[] args) throws Exception {
        String config = ContextConsumer.class.getPackage().getName().replace('.', '/') + "/context-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        ContextService contextService = (ContextService)context.getBean("contextService");
        String dd = contextService.getConfig();
        
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide(); // 本端是否为消费端，这里会返回true
        String serverIP = RpcContext.getContext().getRemoteHost(); // 获取最后一次调用的提供方IP地址
        String application = RpcContext.getContext().getUrl().getParameter("application"); // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        
        
        System.out.println("isConsumerSide = " + isConsumerSide
				+ ",serverIP=" + serverIP 
				+ ",application=" + application );
    }
}
