/**
 * @date:创建时间：2015-12-22上午11:53:01
 * @author:mao
 * 
 */
package com.monkey77.dao;

import com.monkey77.entities.TCookieValidate;
import com.monkey77.entities.TUser;

/**
 * @author mao
 * @time 创建时间 2015-12-22上午11:53:01
 * 
 */
public interface ITCookieValidateDao {

	//保存cookie值
	public void saveCookieValidate(TCookieValidate cookieValidate);
	
	//根据手机号码获取sessionid值
	public TCookieValidate getCookieValidate(TUser user);
}
