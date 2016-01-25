package com.cl.dubbo.zookeeper;

import com.cl.dubbo.BadUser;

public interface ZooService {

	String sayHello(String id);
	
	public void addBadUser(BadUser badUser) ;
}
