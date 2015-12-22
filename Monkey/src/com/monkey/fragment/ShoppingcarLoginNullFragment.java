package com.monkey.fragment;

import com.example.monkey.R;
import com.monkey.activity.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ShoppingcarLoginNullFragment extends Fragment implements OnClickListener{
	private View view;
	private ImageView iv_gotohomeshop;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_shoppingcar_login_null,container, false);
		//"去逛逛"点击事件
		iv_gotohomeshop = (ImageView) view.findViewById(R.id.iv_gotohomeshop);
		return view;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent =null;
		switch (v.getId()) {
		case R.id.iv_gotohomeshop:
			intent = new Intent(this.getActivity(),MainActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
