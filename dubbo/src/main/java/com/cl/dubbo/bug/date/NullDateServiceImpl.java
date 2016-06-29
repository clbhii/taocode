package com.cl.dubbo.bug.date;

public class NullDateServiceImpl implements NullDateService{

	public void question(NullDate nullDate) {
		System.out.println(nullDate.getName() + ":" + nullDate.getDate());
	}
}
