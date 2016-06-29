package com.cl.dubbo.bug.date;

import java.io.Serializable;
import java.sql.Date;

public class NullDate implements Serializable{
	
	private String name;
	
	private java.util.Date utilDate;

	private Date date;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}
	
	
}
