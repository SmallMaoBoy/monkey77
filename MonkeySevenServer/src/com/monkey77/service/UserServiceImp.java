package com.monkey77.service;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.monkey77.dao.ITSmsIdentifyingCodeDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.entities.TSmsIdentifyingCode;
import com.monkey77.entities.TUser;
import com.monkey77.utils.MD5;
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
	 * 返回状态码
	 * 0:成功注册
	 * 1：该号码已被注册
	 * 2：该号码没有发送验证码
	 * 3：验证码出错
	 * @author mao
	 * @date 创建时间：2015-12-19下午10:05:39
	 * @see com.monkey77.service.IUserService#register(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String register(String mobile, String identifyingCode,
			String password) {
		// TODO Auto-generated method stub
		StringBuilder result=new StringBuilder();
		if(userDao.isRegistered(mobile)){
			result.append("1");
		}else{
			String code=smsIdentifyingCodeDao.getIdentifyCode(mobile);
			if(code==null){
				result.append("2");
			}else{
				if(!(code.equals(identifyingCode))){
					result.append("3");
				}else{
					result.append("0");
					TUser user=new TUser();
					user.setMobile(mobile);
					user.setPassword(MD5.getMD5(password));
					user.setName("用户"+mobile);
					userDao.saveUser(user);
				}
			}
		}
		return result.toString();
	}


	/**
	 * * 返回状态码
	 * 0：账号密码一致
	 * 1：该帐号不存在
	 * 2：密码错误
	 * @author mao
	 * @date 创建时间：2015-12-20上午9:08:17
	 * @see com.monkey77.service.IUserService#loginByPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> loginByPassword(String mobile, String password) {
		// TODO Auto-generated method stub
		Map<String,Object> json=new HashMap<String,Object>();
		TUser user=userDao.getUserByMobile(mobile);
		if(user==null){
			json.put("statusCode", "1");
		}else{
			if(user.getPassword().equals(MD5.getMD5(password))){
				json.put("statusCode", "0");
				Map<String,String> data=new HashMap<String,String>();
				data.put("name", user.getName());
				data.put("sex", user.getSex()==0?"男":"女");
				data.put("mobile", user.getMobile());
				json.put("data", data);
			}else{
				json.put("statusCode", "2");
			}
		}
		return json;
	}
	
	
}