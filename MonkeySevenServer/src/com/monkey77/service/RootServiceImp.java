/**
 * @date:创建时间：2015-12-27下午11:37:46
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.monkey77.dao.ITRootDao;
import com.monkey77.entities.TRoot;
import com.monkey77.utils.MD5;

/**
 * @author mao
 * @time 创建时间 2015-12-27下午11:37:46
 * 
 */
public class RootServiceImp implements IRootService{

	private ITRootDao rootDao;
	
	public ITRootDao getRootDao() {
		return rootDao;
	}

	public void setRootDao(ITRootDao rootDao) {
		this.rootDao = rootDao;
	}

	/**
	 *  * * 返回状态码
	 * 0：账号密码一致
	 * 1：该帐号不存在
	 * 2：密码错误
	 * @author mao
	 * @date 创建时间：2015-12-27下午11:38:02
	 * @see com.monkey77.service.IRootService#checkRootLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> checkRootLogin(String account, String password,HttpSession session) {
		// TODO Auto-generated method stub
		Map<String,Object> json=new HashMap<String,Object>();
		String pwd=rootDao.getPasswordByAccount(account);
		if(pwd==null){
			json.put("statusCode", "1");
		}else{
			if(pwd.equals(MD5.getMD5(password))){
				json.put("statusCode", "0");
				session.setAttribute("root", "root");
			}else{
				json.put("statusCode", "2");
			}
		}
		return json;
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-27下午11:38:02
	 * @see com.monkey77.service.IRootService#createNewRoot(java.lang.String, java.lang.String)
	 */
	@Override
	public void createNewRoot(String account, String password) {
		// TODO Auto-generated method stub
		TRoot root=new TRoot();
		root.setAccount(account);
		root.setPassword(MD5.getMD5(password));
		rootDao.createNewRoot(root);
	}

}
