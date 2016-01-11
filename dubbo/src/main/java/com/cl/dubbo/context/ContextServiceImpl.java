package com.cl.dubbo.context;

import com.alibaba.dubbo.rpc.RpcContext;

public class ContextServiceImpl implements ContextService{

	public String getConfig() {
	
		boolean isProviderSide = RpcContext.getContext().isProviderSide(); // 本端是否为提供端，这里会返回true
        String clientIP = RpcContext.getContext().getRemoteHost(); // 获取调用方IP地址
        String application = RpcContext.getContext().getUrl().getParameter("application"); // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        System.out.println("isProviderSide = " + isProviderSide
        					+ ",clientIP=" + clientIP 
        					+ ",application=" + application );
        return "success";
	}
}
