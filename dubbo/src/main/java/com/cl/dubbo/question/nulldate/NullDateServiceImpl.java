package com.cl.dubbo.question.nulldate;

public class NullDateServiceImpl implements NullDateService{

	public void question(NullDate nullDate) {
		System.out.println(nullDate.getName() + ":" + nullDate.getDate());
	}
}
