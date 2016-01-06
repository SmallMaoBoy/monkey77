package com.monkey.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.monkey.utils.ConnUtils;
import com.monkey.utils.PropertiesUtil;

public class UserService {
	String url = PropertiesUtil.getValue("BaseUrl");
	private Handler handler = new Handler();
	
	public UserService(Handler handler) {
		// TODO Auto-generated constructor stub
		super();
		this.handler = handler;
	}

	
	public UserService() {
		super();
	}


	//��ȡ��֤��
	public void sendCheckNum(String mobile) {
		url = url+"RegisterAction_sendIndentifyingCode?mobile="+mobile;
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configTimeout(5000);
		
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			// �������ɹ���Ӧ�ͻ�ʱ���ã�UI�̵߳���
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO Auto-generated method stub
				
			}

			// ��������Ӧ�ͻ�ʧ��ʱ����
			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				Log.d("yan~~", "===>" + error.getMessage());
			}

		});
	}
	
	public void userRegister(String identifyingCode,String mobile,String password){
		url = url+"RegisterAction_register?identifyingCode="+identifyingCode+"&mobile="+mobile+"&password="+password;
		Log.d("url", "====>url:"+url);
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configTimeout(5000);
		
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			// �������ɹ���Ӧ�ͻ�ʱ���ã�UI�̵߳���
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO Auto-generated method stub
				Message msg = new Message();
				Bundle b=new Bundle();
				b.putString("statusCode",responseInfo.result);
				msg.setData(b);
				handler.sendMessage(msg);
			}

			// ��������Ӧ�ͻ�ʧ��ʱ����
			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				Log.d("yan~~", "===>" + error.getMessage());
			}

		});
	}

}
