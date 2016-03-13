/**
 * @date:创建时间：2016-3-10上午1:01:42
 * @author:mao
 * 
 */
package com.monkey77.action;

import java.util.Map;

import com.monkey77.service.IMessageService;
import com.opensymphony.xwork2.Action;

/**
 * @author mao
 * @time 创建时间 2016-3-10上午1:01:42
 * 
 */
public class MessageAction {

	private IMessageService messageService;
	private int userId;
	private String content;
	private String contact;
	private Map<String,Object> map;
	private int indexPage;

	
	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}


	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	
	public String createMessage(){
		messageService.createMessage(userId, content, contact);
		return Action.SUCCESS;
	}
	public String getMessageList(){
		map=messageService.getMessageList(indexPage);
		return Action.SUCCESS;
	}
	
}
