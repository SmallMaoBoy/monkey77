package com.monkey77.service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.monkey77.dao.ITCookieValidateDao;
import com.monkey77.dao.ITSmsIdentifyingCodeDao;
import com.monkey77.dao.ITUserDao;
import com.monkey77.entities.TCookieValidate;
import com.monkey77.entities.TSmsIdentifyingCode;
import com.monkey77.entities.TUser;
import com.monkey77.utils.MD5;
import com.monkey77.utils.SMSSender;

public class UserServiceImp implements IUserService{

	private ITUserDao userDao;
	private ITSmsIdentifyingCodeDao smsIdentifyingCodeDao;
	private ITCookieValidateDao cookieValidateDao;
	private final int num = 12;
	private final String picUrl="imgs/19_avatar_big.jpg";//用户默认头像路径
	
	public ITCookieValidateDao getCookieValidateDao() {
		return cookieValidateDao;
	}


	public void setCookieValidateDao(ITCookieValidateDao cookieValidateDao) {
		this.cookieValidateDao = cookieValidateDao;
	}


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
					user.setPic(picUrl);
					Date d=new Date();
					user.setMobile(mobile);
					user.setPassword(MD5.getMD5(password));
					user.setName("用户"+mobile);
					user.setSex((short) 0);
					user.setBirthday(d);
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
				data.put("id", String.valueOf(user.getId()));
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


	/**
	 * @author mao
	 * @date 创建时间：2015-12-22上午11:45:01
	 * @see com.monkey77.service.IUserService#loginByPasswordWithCookie(java.lang.String, java.lang.String, javax.servlet.http.Cookie[])
	 */
	@Override
	public Map<String, Object> loginByPasswordWithCookie(String mobile,
			String password, HttpServletResponse resopnse,String sessionid) {
		// TODO Auto-generated method stub
		Map<String,Object> json=loginByPassword(mobile,password);
		if(json.get("statusCode").equals("0")){
			TCookieValidate cookieValidate=new TCookieValidate();
			Timestamp time=new Timestamp(System.currentTimeMillis());
			cookieValidate.setCreateTime(time);
			cookieValidate.setSessionId(sessionid);
			cookieValidate.setTUser(userDao.getUserByMobile(mobile));
			cookieValidateDao.saveCookieValidate(cookieValidate);
			Cookie cookie=new Cookie("cookievalidate",sessionid);
			cookie.setMaxAge(60*60*24*7);
			resopnse.addCookie(cookie);
		}
		return json;
	}


	@Override
	public Map<String, Object> getUserList(int indexPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		int count = userDao.count();
		map.put("count", count);
		int page = (indexPage - 1) * num;
		List<TUser> list = userDao.getUserList(page,num);
		map.put("users", list);
		return map;
	}


	/**
	 * @author mao
	 * @date 创建时间：2016-4-4下午8:26:06
	 * @see com.monkey77.service.IUserService#updateUserPicUrl(int, java.lang.String)
	 */
	@Override
	public void updateUserPicUrl(int userId, String picUrl) {
		// TODO Auto-generated method stub
		userDao.updateUserPicUrl(userId, picUrl);
	}


	/**
	 * @author mao
	 * @date 创建时间：2016-4-4下午9:14:32
	 * @see com.monkey77.service.IUserService#getUserInfo(int)
	 */
	@Override
	public Map<String, Object> getUserInfo(int userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("user", userDao.getUserById(userId));
		return map;
	}


	/**
	 * @author mao
	 * @date 创建时间：2016-4-4下午10:21:22
	 * @see com.monkey77.service.IUserService#updateUserInfo(int, java.lang.String, java.lang.String, java.util.Date, int, java.lang.String)
	 */
	@Override
	public Map<String, Object> updateUserInfo(int userId, String mobile,
			String mail, Date date, int sex, String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		try{
			TUser user=userDao.getUserById(userId);
			user.setBirthday(date);
			user.setMail(mail);
			user.setMobile(mobile);
			user.setName(name);
			user.setSex((short) sex);
			userDao.updateUser(user);
			map.put("statusCode", 0);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("statusCode", 1);
		}
		return map;
	}


	/**
	 * @author mao
	 * @date 创建时间：2016-4-6下午1:47:12
	 * @see com.monkey77.service.IUserService#checkPasswordByUserId(int, java.lang.String)
	 */
	@Override
	public Map<String, Object> checkPasswordByUserId(int userId, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
			TUser user=userDao.getUserById(userId);
			if(user.getPassword().equals(MD5.getMD5(password))){
				map.put("statusCode", 0);
			}else{
				map.put("statusCode", 1);
			}
			return map;
	}


	/**
	 * @author mao
	 * @date 创建时间：2016-4-6下午2:12:04
	 * @see com.monkey77.service.IUserService#updatePasswordByUserId(int, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> updatePasswordByUserId(int userId,
			String password, String newPassword) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		TUser user=userDao.getUserById(userId);
		if(user.getPassword().equals(MD5.getMD5(password))){
			user.setPassword(MD5.getMD5(newPassword));
			userDao.updateUser(user);
			map.put("statusCode", 0);
		}else{
			map.put("statusCode", 1);
		}
		return map;
	}
	
	
}
