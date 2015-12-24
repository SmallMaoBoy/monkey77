package com.monkey.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 设置透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 设置透明工具栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

	}

}
