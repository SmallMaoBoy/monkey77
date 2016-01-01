package com.monkey.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.monkey.R;
import com.monkey.utils.XmlUtils;

public class LoginActivity extends Activity implements OnClickListener{
	private ImageView iv_login_back;
	private Button btn_login;
	private TextView tv_login_register;
	private EditText et_input_loginPhone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		iv_login_back = (ImageView) findViewById(R.id.iv_login_back);
		iv_login_back.setOnClickListener(this);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
		tv_login_register = (TextView) findViewById(R.id.tv_login_register);
		tv_login_register.setOnClickListener(this);
		et_input_loginPhone = (EditText) findViewById(R.id.et_input_loginPhone);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.iv_login_back:
			intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_login:
			XmlUtils.saveData(this, "user", "userName", "дьЁф");
			XmlUtils.saveData(this, "user", "phone", et_input_loginPhone.getText().toString());
			intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			break;
		case R.id.tv_login_register:
			intent = new Intent(this,RegisterActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
