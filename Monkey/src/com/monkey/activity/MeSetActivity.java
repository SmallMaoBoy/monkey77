package com.monkey.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.monkey.R;
import com.monkey.utils.XmlUtils;

public class MeSetActivity extends Activity implements OnClickListener{
	private Button btn_unsignLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_me_set);
		//注销登录按钮事件
		btn_unsignLogin = (Button) findViewById(R.id.btn_unsignLogin);
		btn_unsignLogin.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_unsignLogin:
			XmlUtils.saveData(this, "user", "userName", "");
			XmlUtils.saveData(this, "user", "phone", "");
			intent = new Intent(this,LoginActivity.class);
			startActivity(intent);			
			break;

		default:
			break;
		}
	}

}
