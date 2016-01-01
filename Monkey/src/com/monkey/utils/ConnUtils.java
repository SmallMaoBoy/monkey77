package com.monkey.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.util.Log;

public class ConnUtils {
	private static String result;

	public static String conn(String url) throws Exception {
		// TODO Auto-generated method stub
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configTimeout(5000);
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			// 服务器成功响应客户时调用，UI线程调用
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO Auto-generated method stub
				Log.d("yan", "===>" + responseInfo.result);
				result = responseInfo.result;
			}

			// 服务器响应客户失败时调用
			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				Log.d("yan~~", "===>" + error.getMessage());
			}

		});
		Log.d("yan!!", "===>" + result);
		return result;
		
//		
//		 URL u = new URL(url);
//		 HttpURLConnection conn = (HttpURLConnection) u.openConnection();
//		 conn.setConnectTimeout(5000);
//		 InputStream is = conn.getInputStream();
//		 BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		 String temp = null;
//		 while ((temp = br.readLine()) != null) {
//		 Log.d("yan", "====>" + temp);
//		 }
//		 return temp;

	}

}
