package com.cl.dubbo;

import java.io.Serializable;
import java.sql.Date;


/**
 * 
 * @author Administrator
 *
 */
public class BadUser implements Serializable {

	private String userName;
//  rmi协议，必须提供默认构造方法，否则无法序列化
//	public BadUser(String userName) {
//		super();
//		this.userName = userName;
//	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
	
