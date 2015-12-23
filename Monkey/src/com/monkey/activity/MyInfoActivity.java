package com.monkey.activity;

import com.example.monkey.R;
import com.monkey.fragment.MeFragment;
import com.monkey.utils.XmlUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyInfoActivity extends BaseActivity implements OnClickListener{
	private EditText et_input_secondName;
    private TextView tv_saveMyInfo;
    private EditText et_input_phone;
    private ImageView iv_myinfo_back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acivity_myinfo);
		et_input_secondName = (EditText) findViewById(R.id.et_input_secondName);
		System.out.println(et_input_secondName.getText());
		//设置‘保存’按钮的事件监听
		tv_saveMyInfo = (TextView) findViewById(R.id.tv_saveMyInfo);
		tv_saveMyInfo.setOnClickListener(this);
		//显示电话号码，且不能进行修改
		et_input_phone = (EditText) findViewById(R.id.et_input_phone);
		et_input_phone.setText(XmlUtils.readStringData(this, "user", "phone"));
		et_input_phone.setEnabled(false);
		//返回键
		iv_myinfo_back = (ImageView) findViewById(R.id.iv_myinfo_back);
		iv_myinfo_back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent=null;
		switch (v.getId()) {
		case R.id.tv_saveMyInfo:
			XmlUtils.saveData(this, "user", "userName", et_input_secondName.getText().toString());	
			Toast.makeText(this, "个人信息保存成功", Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_myinfo_back:
			intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}
