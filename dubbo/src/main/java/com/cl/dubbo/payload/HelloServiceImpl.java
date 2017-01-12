package com.cl.dubbo.payload;

public class HelloServiceImpl implements HelloService{

	public String sayHello(String name) {
		int size = 1024*1024*1024;
		char[] arr = new char[size];
		for(int i = 0; i < size; i++) {
			arr[i] = 'A';
		}
		String result = new String(arr);
		return result;
	}
}
