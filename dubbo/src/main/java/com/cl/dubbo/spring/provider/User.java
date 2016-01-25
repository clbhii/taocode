package com.cl.dubbo.spring.provider;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("user")
public class User implements Serializable {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
