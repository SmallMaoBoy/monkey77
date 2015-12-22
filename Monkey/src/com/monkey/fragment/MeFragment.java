package com.monkey.fragment;

import com.example.monkey.R;
import com.example.monkey.R.layout;
import com.monkey.activity.LoginActivity;
import com.monkey.activity.MyInfoActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MeFragment extends Fragment implements OnClickListener {
	private View view;
	private RelativeLayout rl_tologin_tomyinfo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_me, container, false);
		rl_tologin_tomyinfo = (RelativeLayout) view
				.findViewById(R.id.rl_tologin_tomyinfo);
		rl_tologin_tomyinfo.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.rl_tologin_tomyinfo:
			TextView tv_login = (TextView) v.findViewById(R.id.tv_login);
			Intent intent = null;
			if (tv_login.getText().equals("сн©м")) {
				intent = new Intent(this.getActivity(), LoginActivity.class);
				startActivity(intent);
			} else {
				intent = new Intent(this.getActivity(), MyInfoActivity.class);
				startActivity(intent);
			}
			break;

		default:
			break;
		}
	}

}
