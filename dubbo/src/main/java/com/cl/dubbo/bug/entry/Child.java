package com.cl.dubbo.bug.entry;

public class Child extends Parent{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSuperName() {
		return super.getName();
	}
	
	public void setSuperName(String name) {
		super.setName(name);
	}
	
}
