package com.monkey.fragment;

import com.example.monkey.R;
import com.monkey.activity.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShoppingcarUnloginFragment extends Fragment implements OnClickListener{
	private View view;
	private TextView tv_gotologin;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_shoppingcar_unlogin,container, false);
		//设置“登录”的点击事件
		tv_gotologin = (TextView) view.findViewById(R.id.tv_gotologin);
		tv_gotologin.setOnClickListener(this);
		return view;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent =null;
		switch (v.getId()) {
		case R.id.tv_gotologin:
			intent = new Intent(this.getActivity(),LoginActivity.class);			
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
