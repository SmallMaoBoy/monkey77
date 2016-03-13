/**
 * @date:创建时间：2016-3-10上午12:06:09
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TGood;
import com.monkey77.entities.TMessage;

/**
 * @author mao
 * @time 创建时间 2016-3-10上午12:06:09
 * 
 */
public interface ITMessageDao {

	public void createNewMessage(TMessage message);
	
	public List<TMessage> getMessage(int indexPage,int num);
	
	public int getMessageCount();
	
}
