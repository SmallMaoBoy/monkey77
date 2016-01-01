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
				Toast.makeText(getApplication(), "�ɹ�ע��", Toast.LENGTH_SHORT).show();
				intent = new Intent(getApplication(),LoginActivity.class);
				startActivity(intent);
				break;
			case "1":
				Toast.makeText(getApplication(), "���˺��ѱ�ע��", Toast.LENGTH_SHORT).show();
				break;
			case "2":
				Toast.makeText(getApplication(), "�ú���û�з�����֤��", Toast.LENGTH_SHORT).show();
				break;
			case "3":
				Toast.makeText(getApplication(), "��֤�����", Toast.LENGTH_SHORT).show();
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
		//ע�ᰴť
		sureRegister = (Button) findViewById(R.id.btn_sureRegister);
		sureRegister.setOnClickListener(this);
		//���ذ�ť
		iv_register_back = (ImageView) findViewById(R.id.iv_register_back);
		iv_register_back.setOnClickListener(this);
		//��ȡ��֤�밴ť
		iv_getcheckNum = (ImageView) findViewById(R.id.iv_getcheckNum);
		iv_getcheckNum.setOnClickListener(this);
		//����֤�롱����
		tv_getcheckNum = (TextView) findViewById(R.id.tv_getcheckNum);
		//��֤�������
		et_inputCheckNum = (EditText) findViewById(R.id.et_inputCheckNum);
		//�ֻ����������
		et_phoneNum = (EditText) findViewById(R.id.et_phoneNum);
		//���������
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
				Toast.makeText(this, "���벻һ�£�����������",Toast.LENGTH_LONG).show();
			}else if(mobile.equals(null) || identifyingCode.equals(null)){
				Toast.makeText(this, "�ֻ��������֤�벻��Ϊ��",Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(this, "����Ϊ��ע�ᣬ�����ĵȺ�",Toast.LENGTH_LONG).show();
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
			new CountDownTimer(60000, 1000) { //60�뵹��ʱ��ÿ��ִ��һ��
				public void onTick(long millisUntilFinished) { //ÿ��ִ��һ�ν��÷���
					iv_getcheckNum.setClickable(false);
					tv_getcheckNum.setText("����ʱ" + millisUntilFinished / 1000+"s"); 
				} 
				public void onFinish() { //����ʱ������
					tv_getcheckNum.setText("���·���"); 
					iv_getcheckNum.setClickable(true);
				} 
				}.start();
		default:
			break;
		}
	}

}
