package com.cl.fastjson.jsonpath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSONPath;

/**
 * 根据path查找元素
 * 
 * @author Administrator
 *
 */
public class JsonPathTest {

	public void test_entity() throws Exception {
		Entity entity = new Entity(123, new Object());
//		Assert.assertSame(entity.getValue(), JSON.eval(entity, "$.value"));
//		Assert.assertTrue(JSON.contains(entity, "$.value"));
//		Assert.assertTrue(JSON.containsValue(entity, "$.id", 123));
//		Assert.assertTrue(JSON.containsValue(entity, "$.value", entity.getValue()));
//		Assert.assertEquals(2, JSON.size(entity, "$"));
//		Assert.assertEquals(0, JSON.size(new Object[], "$"));
	}

	@Test
	public void test() {
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(new Entity("wenshao"));
		entities.add(new Entity("ljw2083"));

		List<String> names = (List<String>) JSONPath.eval(entities, "$.name"); // 返回enties的所有名称
		Assert.assertSame(entities.get(0).getName(), names.get(0));
		Assert.assertSame(entities.get(1).getName(), names.get(1));
	}
	@Test
	public void test1() {
		List<Entity> entities = new ArrayList<Entity>();
	    entities.add(new Entity("wenshao"));
	    entities.add(new Entity("ljw2083"));
	    entities.add(new Entity("Yako"));

	    List<Entity> result = (List<Entity>)JSONPath.eval(entities, "[1,2]"); // 返回下标为1和2的元素
	    Assert.assertEquals(2, result.size());
	    Assert.assertSame(entities.get(1), result.get(0));
	    Assert.assertSame(entities.get(2), result.get(1));
	}

}
