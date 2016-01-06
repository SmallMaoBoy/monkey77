package com.monkey.activity;

import com.example.monkey.R;
import com.monkey.threads.WelcomeActivityThread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
	   Thread thread = new Thread(new WelcomeActivityThread(this));
	   thread.start();   
		
	}

}
