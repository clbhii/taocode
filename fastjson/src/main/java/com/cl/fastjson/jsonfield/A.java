package com.cl.fastjson.jsonfield;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
/**
 * public @interface JSONField {
    // 配置序列化和反序列化的顺序，1.1.42版本之后才支持
    int ordinal() default 0;

     // 指定字段的名称
    String name() default "";

    // 指定字段的格式，对日期格式有用
    String format() default "";

    // 是否序列化
    boolean serialize() default true;

    // 是否反序列化
    boolean deserialize() default true;
}
 * @author Administrator
 *
 */
public class A {

	private int id;

	@JSONField(name = "ID")
	public int getId() {
		return id;
	}

	@JSONField(name = "ID")
	public void setId(int value) {
		this.id = id;
	}
	
	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.date = new Date();
		a1.date1 = new Date();
		System.out.println(JSON.toJSONString(a1));
		
		SerializeConfig mapping = new SerializeConfig();
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd")); //yyyy-MM-dd
		System.out.println(JSON.toJSONString(a1,mapping));
	}
	
	
}

class A1 {
    @JSONField(name="ID")
    private int id;

    // 配置date序列化和反序列使用yyyyMMdd日期格式
    @JSONField(format="yyyyMMdd")
    public Date date;
    
    public Date date1;
    
    public int getId() {return id;}
    public void setId(int value) {this.id = id;}
}