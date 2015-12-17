package com.monkey77.test.utils;

import org.junit.Test;

import com.monkey77.utils.SMSSender;

public class TestSMSSendUtil {

	@Test
	public void testSendMSM(){
		SMSSender.sendSMS("", "5201314");
	}
}
