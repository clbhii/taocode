package com.cl.jackson.ignoreproperties;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IgnorePropertiesTest {
	@Test
	public void test() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		MyDto dtoObject = new MyDto();
		String dtoAsString = mapper.writeValueAsString(dtoObject);
		System.out.println(dtoAsString);
	}
}
