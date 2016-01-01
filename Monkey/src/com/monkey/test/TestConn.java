package com.monkey.test;

import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.monkey.json.Good;

public class TestConn extends AndroidTestCase {

	public void test() {

		String url = "http://139.129.41.240:8080/MonkeySevenServer/GoodAction_getDefalutGoods?page=1&oerderType=0";
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.configTimeout(5000);
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			// 服务器成功响应客户时调用，UI线程调用
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO Auto-generated method stub
				Log.d("yan", "===>" + responseInfo.result);
				Log.d("yan", "===>" + responseInfo.toString());
				Gson gson = new Gson();
				MyJson my=gson.fromJson(responseInfo.result, MyJson.class);
				Log.d("mao", "===>" +my.getGoods());
			}

			// 服务器响应客户失败时调用
			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				Log.d("yan~~", "===>" + error.getMessage());
			}

		});

		// try {
		// conn(url);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		//
		// private String conn(String url) throws Exception {
		// // TODO Auto-generated method stub
		// URL u = new URL(url);
		// HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		// conn.setConnectTimeout(5000);
		// InputStream is = conn.getInputStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// String temp = null;
		// while ((temp = br.readLine()) != null) {
		// Log.d("yan", "====>" + temp);
		// }
		// return temp;
	}
	
	private class MyJson{
		private String account;
		private List<Good> goods=new ArrayList<Good>();
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public List<Good> getGoods() {
			return goods;
		}
		public void setGoods(List<Good> goods) {
			this.goods = goods;
		}
	}

}
