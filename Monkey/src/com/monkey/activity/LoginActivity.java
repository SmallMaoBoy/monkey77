package com.monkey.activity;

import com.example.monkey.R;
import com.monkey.fragment.MeFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends BaseActivity implements OnClickListener{
	private ImageView iv_login_back;
	private Button btn_login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		iv_login_back = (ImageView) findViewById(R.id.iv_login_back);
		iv_login_back.setOnClickListener(this);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.iv_login_back:
			intent = new Intent(this,MeFragment.class);
			startActivity(intent);
			break;
		case R.id.btn_login:
			intent = new Intent(this,RegisterActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
