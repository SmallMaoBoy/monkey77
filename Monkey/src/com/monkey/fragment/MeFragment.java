package com.monkey.fragment;

import com.example.monkey.R;
import com.monkey.activity.LoginActivity;
import com.monkey.activity.MeSetActivity;
import com.monkey.activity.MyInfoActivity;
import com.monkey.utils.XmlUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MeFragment extends Fragment implements OnClickListener {
	private View view;
	private RelativeLayout rl_tologin_tomyinfo;
	private TextView tv_login;
	private TextView tv_phone;
	private LinearLayout ll_me_set;
	// private ImageView iv_user_pic;
	private String userName;
	private String phone;
	private String user_pic;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_me, container, false);
		rl_tologin_tomyinfo = (RelativeLayout) view
				.findViewById(R.id.rl_tologin_tomyinfo);
		rl_tologin_tomyinfo.setOnClickListener(this);

		tv_login = (TextView) view.findViewById(R.id.tv_login);
		tv_phone = (TextView) view.findViewById(R.id.tv_phone);
		// iv_user_pic = (ImageView) view.findViewById(R.id.iv_user_pic);
		//查看user的xml文件  并获取信息。
		CheckUser();
		//设置栏
		ll_me_set = (LinearLayout) view.findViewById(R.id.ll_me_set);
		ll_me_set.setOnClickListener(this);
		return view;
	}

	private void CheckUser() {
		// TODO Auto-generated method stub
		userName = XmlUtils.readStringData(this.getActivity(), "user", "userName");
		phone = XmlUtils.readStringData(this.getActivity(), "user", "phone");
		//判断userName和phone的值是否存在
		if (userName == "" && phone == "") {
			tv_login.setText("游客");
			tv_phone.setText("点击登录");
		}else{
			tv_login.setText(userName);
			tv_phone.setText(phone);
		}		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.rl_tologin_tomyinfo:
			Intent intent = null;
			if (tv_login.getText().equals("游客")) {
				intent = new Intent(this.getActivity(), LoginActivity.class);// 如果是游客，跳到登录界面
				startActivity(intent);
			} else {
				intent = new Intent(this.getActivity(), MyInfoActivity.class);// 显示用户名时，跳到我的资料界面
				startActivity(intent);
			}
			break;
		case R.id.ll_me_set:
			intent = new Intent(this.getActivity(), MeSetActivity.class);// 跳转到设置界面
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
