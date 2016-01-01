package com.monkey.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.monkey.json.Good;
import com.monkey.json.GoodMsg;
import com.monkey.utils.ConnUtils;
import com.monkey.utils.PropertiesUtil;

public class HomeService {

	private Handler handler;
	
	
	public HomeService(Handler handler) {
		super();
		this.handler = handler;
	}

	public void getGoods() {
		String url = PropertiesUtil.getValue("BaseUrl") + "GoodAction_getDefalutGoods?page=1&oerderType=0";

		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configTimeout(5000);
		
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			// 服务器成功响应客户时调用，UI线程调用
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO Auto-generated method stub
				Message message=new Message();
				Bundle b=new Bundle();
				b.putString("result",responseInfo.result);
				b.putInt("type", 1);
				message.setData(b);
				handler.sendMessage(message);
				
			}

			// 服务器响应客户失败时调用
			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				Log.d("yan~~", "===>" + error.getMessage());
			}

		});
		
		
	}

}
