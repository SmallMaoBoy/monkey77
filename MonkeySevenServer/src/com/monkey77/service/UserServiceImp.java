package com.monkey77.service;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;

import com.monkey77.dao.ITSmsIdentifyingCodeDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.entities.TSmsIdentifyingCode;
import com.monkey77.utils.SMSSender;

public class UserServiceImp implements IUserService{

	private ITUserDao userDao;
	private ITSmsIdentifyingCodeDao smsIdentifyingCodeDao;
	
	
	
	public ITSmsIdentifyingCodeDao getSmsIdentifyingCodeDao() {
		return smsIdentifyingCodeDao;
	}


	public void setSmsIdentifyingCodeDao(
			ITSmsIdentifyingCodeDao smsIdentifyingCodeDao) {
		this.smsIdentifyingCodeDao = smsIdentifyingCodeDao;
	}


	public ITUserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(ITUserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public String isExistMobile(String mobile) {
		// TODO Auto-generated method stub
		return userDao.isRegistered(mobile)==true?"0":"1";
	}


	@Override
	public void sendIdentifyingCode(String mobile) throws Exception {
		// TODO Auto-generated method stub
		String identifyingCode=SMSSender.createIdentifyingCode();
		String result=SMSSender.send(mobile,identifyingCode);
		System.out.println(result);
		JSONObject dataJson=JSONObject.fromObject(result);
		JSONObject resp=dataJson.getJSONObject("resp");
		String respCode=resp.getString("respCode");
		if(respCode.equals("000000")){
			TSmsIdentifyingCode smsIdentifyingCode=new TSmsIdentifyingCode();
			smsIdentifyingCode.setIdentifyingCode(identifyingCode);
			smsIdentifyingCode.setMobile(mobile);
			Timestamp time=new Timestamp(System.currentTimeMillis());
			smsIdentifyingCode.setCreateTime(time);
			smsIdentifyingCodeDao.saveOrUpdateIdentifyingCode(smsIdentifyingCode);
		}else{
			throw new Exception("fail to send SMS...");
		}
		
		
	}

}
