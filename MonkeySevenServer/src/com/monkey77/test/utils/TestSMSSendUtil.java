package com.monkey77.test.utils;

import org.junit.Test;

import com.monkey77.utils.SMSSender;

public class TestSMSSendUtil {

	@Test
	public void testSendMSM(){
		System.out.println(SMSSender.send("13631315179",SMSSender.createIdentifyingCode()));
	}
	
	@Test
	public void testCreateIdentifyingCode(){
		for(int i=0;i<100;i++)
			System.out.print(SMSSender.createIdentifyingCode()+"      ");
	}
}
