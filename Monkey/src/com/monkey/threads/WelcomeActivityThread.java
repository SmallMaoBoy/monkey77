package com.monkey.threads;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.monkey.activity.GuideActivity;
import com.monkey.activity.MainActivity;
import com.monkey.utils.XmlUtils;

public class WelcomeActivityThread implements Runnable {
	private Context context;
	private String isFirstUse;
	private boolean isShowGuide;
	private Handler handler = new Handler(){//ui线程做的事
		public void handleMessage(android.os.Message msg){
			Intent intent = null;
			if(isShowGuide==true){
				intent = new Intent(context,GuideActivity.class);
			}else{
				intent = new Intent(context,MainActivity.class);				
			}
			context.startActivity(intent);
		}
	};
	public WelcomeActivityThread(Context context) {
		super();
		this.context = context;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		checkIsFirstTime();
		handler.sendEmptyMessageDelayed(0, 3000);
	}

	private void checkIsFirstTime() {
		// TODO Auto-generated method stub
		isFirstUse = XmlUtils.readStringData(context, "config", "isFirstUse");
		if(isFirstUse.equals("false")){
			isShowGuide=false;
		}else{
			isShowGuide=true;
			XmlUtils.saveData(context, "config", "isFirstUse", "false");
		}
	}

}
