package com.monkey.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monkey.R;
import com.monkey.service.UserService;

public class RegisterActivity extends Activity implements OnClickListener{
	private Intent intent = null;
	private Button sureRegister;
	private ImageView iv_register_back;
	private ImageView iv_getcheckNum;
	private TextView tv_getcheckNum;
	private EditText et_inputCheckNum;
	private EditText et_phoneNum;
	private EditText et_firstPsd;
	private EditText et_secondPsd;
	UserService userService;
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			String statusCode = (String) msg.getData().get("statusCode");
			switch (statusCode) {
			case "0":
				Toast.makeText(getApplication(), "成功注册", Toast.LENGTH_SHORT).show();
				intent = new Intent(getApplication(),LoginActivity.class);
				startActivity(intent);
				break;
			case "1":
				Toast.makeText(getApplication(), "该账号已被注册", Toast.LENGTH_SHORT).show();
				break;
			case "2":
				Toast.makeText(getApplication(), "该号码没有发送验证码", Toast.LENGTH_SHORT).show();
				break;
			case "3":
				Toast.makeText(getApplication(), "验证码出错", Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		//注册按钮
		sureRegister = (Button) findViewById(R.id.btn_sureRegister);
		sureRegister.setOnClickListener(this);
		//返回按钮
		iv_register_back = (ImageView) findViewById(R.id.iv_register_back);
		iv_register_back.setOnClickListener(this);
		//获取验证码按钮
		iv_getcheckNum = (ImageView) findViewById(R.id.iv_getcheckNum);
		iv_getcheckNum.setOnClickListener(this);
		//“验证码”字样
		tv_getcheckNum = (TextView) findViewById(R.id.tv_getcheckNum);
		//验证码输入框
		et_inputCheckNum = (EditText) findViewById(R.id.et_inputCheckNum);
		//手机号码输入框
		et_phoneNum = (EditText) findViewById(R.id.et_phoneNum);
		//密码输入框
		et_firstPsd = (EditText) findViewById(R.id.et_firstPsd);
		et_secondPsd  = (EditText) findViewById(R.id.et_secondPsd);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.btn_sureRegister:
			String firstPsd = et_secondPsd.getText().toString();
			String secondPsd = et_firstPsd.getText().toString();
			String mobile = et_phoneNum.getText().toString();
			String identifyingCode = et_inputCheckNum.getText().toString();
			userService = new UserService(handler);
			if(secondPsd.equals(firstPsd) && mobile!=null && identifyingCode!=null){
				userService.userRegister(identifyingCode, mobile, secondPsd);
			}else if(!secondPsd.equals(firstPsd)){
				Toast.makeText(this, "密码不一致，请重新输入",Toast.LENGTH_LONG).show();
			}else if(mobile.equals(null) || identifyingCode.equals(null)){
				Toast.makeText(this, "手机号码或验证码不能为空",Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(this, "现在为您注册，请耐心等候！",Toast.LENGTH_LONG).show();
			}
			
			
			break;
		case R.id.iv_register_back:
			intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.iv_getcheckNum:
			Log.d("buxing", "---->"+et_phoneNum.getText().toString());	
			userService = new UserService();
			userService.sendCheckNum(et_phoneNum.getText().toString());			
			new CountDownTimer(60000, 1000) { //60秒倒计时，每秒执行一次
				public void onTick(long millisUntilFinished) { //每秒执行一次进该方法
					iv_getcheckNum.setClickable(false);
					tv_getcheckNum.setText("倒计时" + millisUntilFinished / 1000+"s"); 
				} 
				public void onFinish() { //倒计时结束。
					tv_getcheckNum.setText("重新发送"); 
					iv_getcheckNum.setClickable(true);
				} 
				}.start();
		default:
			break;
		}
	}

}
