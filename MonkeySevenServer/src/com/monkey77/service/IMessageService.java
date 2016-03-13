/**
 * @date:创建时间：2016-3-10上午12:49:57
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Map;

/**
 * @author mao
 * @time 创建时间 2016-3-10上午12:49:57
 * 
 */
public interface IMessageService {

	public void createMessage(int userId,String content,String contact);
	public Map<String, Object> getMessageList(int indexPage);
	
}
