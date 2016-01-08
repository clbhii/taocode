package com.cl.fastjson.serializefilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.support.odps.udf.CodecCheck.A;

/**
 * SerializeFilter是通过编程扩展的方式定制序列化。fastjson支持6种SerializeFilter，用于不同场景的定制序列化。

	PropertyPreFilter 根据PropertyName判断是否序列化
	PropertyFilter 根据PropertyName和PropertyValue来判断是否序列化
	NameFilter 修改Key，如果需要修改Key,process返回值则可
	ValueFilter 修改Value
	BeforeFilter 序列化时在最前添加内容
	AfterFilter 序列化时在最后添加内容
 * @author Administrator
 *
 */
public class SerializeFilterTest {
	public static void PropertyFilterTest() {
		PropertyFilter filter = new PropertyFilter() {

	        public boolean apply(Object source, String name, Object value) {
	            if ("id".equals(name)) {
	                int id = ((Integer) value).intValue();
	                return id >= 100;
	            }
	            return false;
	        }
	    };
	    A a = new A();
	    a.setId(1000);
	    String toString = JSON.toJSONString(a, filter); // 序列化的时候传入filter
	    System.out.println(toString);
	}
	
	public static void main(String[] args) {
		PropertyFilterTest();
	}
}
