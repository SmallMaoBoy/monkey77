/**
 * @date:创建时间：2016-3-10上午12:52:19
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.sql.Timestamp;

import com.monkey77.dao.ITMessageDao;
import com.monkey77.entities.TMessage;
import com.monkey77.entities.TUser;

/**
 * @author mao
 * @time 创建时间 2016-3-10上午12:52:19
 * 
 */
public class MessageServiceImp implements IMessageService {
	
	private ITMessageDao messageDao;
	

	public ITMessageDao getMessageDao() {
		return messageDao;
	}


	public void setMessageDao(ITMessageDao messageDao) {
		this.messageDao = messageDao;
	}


	/**
	 * @author mao
	 * @date 创建时间：2016-3-10上午12:52:19
	 * @see com.monkey77.service.IMessageService#createMessage(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void createMessage(int userId, String content, String contact) {
		// TODO Auto-generated method stub
		TMessage m=new TMessage();
		TUser user=new TUser();
		user.setId(userId);
		m.setContact(contact);
		m.setContent(content);
		m.setCreateTime(new Timestamp(System.currentTimeMillis()));
		m.setTUser(user);
		messageDao.createNewMessage(m);
	}

}
