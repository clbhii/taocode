package com.cl.dubbo.zookeeper;

import com.cl.dubbo.BadUser;

public class ZooServiceImpl implements ZooService {

	public String sayHello(String id) {
		return "hello" + id;
	}
	
	public void addBadUser(BadUser badUser) {
		System.out.println(badUser);
	}

}
