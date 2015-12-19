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


	/**
	 * 返回Json数据{statusCode:?}
	 * 0:成功注册
	 * 1：
	 * @author mao
	 * @date 创建时间：2015-12-19下午10:05:39
	 * @see com.monkey77.service.IUserService#register(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String register(String mobile, String identifyingCode,
			String password) {
		// TODO Auto-generated method stub
		StringBuilder result=new StringBuilder();
		if(!smsIdentifyingCodeDao.getIdentifyCode(mobile).equals(identifyingCode)){
			
		}
		return result.toString();
	}



}
