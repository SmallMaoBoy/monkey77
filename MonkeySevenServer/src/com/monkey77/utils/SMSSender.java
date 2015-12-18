package com.monkey77.utils;

import com.monkey77.SMS.RestTest;


public class SMSSender {
	
	public static String send(String mobile,String indetifyingCode){
		String accountSid=PropertiesUtil.getValue("/SMSconfig.properties", "accountSid");
		String authToken=PropertiesUtil.getValue("/SMSconfig.properties", "authToken");
		String appId=PropertiesUtil.getValue("/SMSconfig.properties", "appId");
		String templateId=PropertiesUtil.getValue("/SMSconfig.properties", "templateId");
		String periodOfValidity=PropertiesUtil.getValue("/SMSconfig.properties", "periodOfValidity");
		return RestTest.sendSMS(true, accountSid, authToken, appId, templateId, mobile,indetifyingCode+","+periodOfValidity);
	}
	
}
