package com.monkey77.test.utils;

import org.junit.Test;

import com.monkey77.utils.PropertiesUtil;

public class TestPropertiesUtils {
	
	@Test
	public void testGetValue(){
		
		System.out.println(PropertiesUtil.getValue("/SMS_indetifyingCode.properties", "periodOfValidity"));
	}
}
