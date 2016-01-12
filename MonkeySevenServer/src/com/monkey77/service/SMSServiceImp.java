/**
 * @date:创建时间：2015-12-28下午4:51:07
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.monkey77.SMS.client.JsonReqClient;
import com.monkey77.utils.PropertiesUtil;

/**
 * @author mao
 * @time 创建时间 2015-12-28下午4:51:07
 * 
 */
public class SMSServiceImp implements ISMSService{

	
	private JsonReqClient jsonReqClient=new JsonReqClient();
	private static final String accountSid=PropertiesUtil.getValue("/SMSconfig.properties", "accountSid");
	private static final String authToken=PropertiesUtil.getValue("/SMSconfig.properties", "authToken");
	private static final String appId=PropertiesUtil.getValue("/SMSconfig.properties", "appId");
	private static final String templateId=PropertiesUtil.getValue("/SMSconfig.properties", "templateId");
	private static final String periodOfValidity=PropertiesUtil.getValue("/SMSconfig.properties", "periodOfValidity");

	/**
	 * @author mao
	 * @date 创建时间：2015-12-28下午4:51:24
	 * @see com.monkey77.service.ISMSService#getAccountInfo()
	 */
	@Override
	public Map<String, Object> getAccountInfo() {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		String date=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println(date);
		map.put("result", jsonReqClient.billList(accountSid, authToken, appId, date));
		return map;
	}

}
