package com.cl.dubbo.zookeeper;

import java.util.Map;

import com.cl.dubbo.BadUser;

public class ZooServiceImpl implements ZooService {

	public String sayHello(String id) {
		return "hello" + id;
	}
	
	public void addBadUser(BadUser badUser) {
		System.out.println(badUser);
	}

	public void addA(A a) {
		System.out.println(a);
	}

	public void addMap(Map<String, Object> map) {
		System.out.println(map);
	}
	
	

}
