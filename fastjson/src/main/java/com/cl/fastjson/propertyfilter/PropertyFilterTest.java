package com.cl.fastjson.propertyfilter;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class PropertyFilterTest {

	public static void test() {
		PropertyFilter filter = new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				return false;
			}
		};

		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		serializer.getPropertyFilters().add(filter);

		A a = new A();
		serializer.write(a);

		String text = out.toString();
		System.out.println(text);
	}

	public static void test1() {
		PropertyFilter filter = new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if ("name".equals(name)) {
					return true;
				}
				return false;
			}
		};

		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		serializer.getPropertyFilters().add(filter);

		A a = new A();
		a.setName("chennp2008");
		serializer.write(a);

		String text = out.toString();
		System.out.println(text);
	}

	public static void main(String[] args) {
		test();
		test1();
	}
}
