package com.monkey.activity;

import com.example.monkey.R;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterActivity extends BaseActivity implements OnClickListener{
	private Button sureRegister;
	private ImageView iv_register_back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		sureRegister = (Button) findViewById(R.id.btn_sureRegister);
		sureRegister.setOnClickListener(this);
		iv_register_back = (ImageView) findViewById(R.id.iv_register_back);
		iv_register_back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_sureRegister:
			intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.iv_register_back:
			intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
