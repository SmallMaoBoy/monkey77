package com.monkey77.utils;

import java.util.Random;

import com.monkey77.SMS.RestTest;


public class SMSSender {
	
	public static String send(String mobile,String identifyingCode){
		String accountSid=PropertiesUtil.getValue("/SMSconfig.properties", "accountSid");
		String authToken=PropertiesUtil.getValue("/SMSconfig.properties", "authToken");
		String appId=PropertiesUtil.getValue("/SMSconfig.properties", "appId");
		String templateId=PropertiesUtil.getValue("/SMSconfig.properties", "templateId");
		String periodOfValidity=PropertiesUtil.getValue("/SMSconfig.properties", "periodOfValidity");
		return RestTest.sendSMS(true, accountSid, authToken, appId, templateId, mobile,identifyingCode+","+periodOfValidity);
	}
	
	public static String createIdentifyingCode(){
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for(int i=0;i<Integer.valueOf(PropertiesUtil.getValue("/SMSconfig.properties", "numberOfValidity"));i++){
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}
	
}
