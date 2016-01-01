package com.monkey.test;


import com.monkey.utils.PropertiesUtil;

public class TestPropeoties {

	public static void main(String arg[]){
		testPro();
	}
	public  static void testPro(){
		System.out.println(PropertiesUtil.getValue("BaseUrl"));
	}
}
