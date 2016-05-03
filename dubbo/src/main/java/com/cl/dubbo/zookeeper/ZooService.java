package com.cl.dubbo.zookeeper;

import java.util.Map;

import com.cl.dubbo.BadUser;

public interface ZooService {

	String sayHello(String id);
	
	public void addBadUser(BadUser badUser) ;
	
	public void addA(A a) ;
	public void addMap(Map<String, Object> map) ;
}
