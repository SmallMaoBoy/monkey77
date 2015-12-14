package com.monkey.activity;

import com.example.monkey.R;
import com.monkey.fragment.CategroyFragment;
import com.monkey.fragment.HomeFragment;
import com.monkey.fragment.MeFragment;
import com.monkey.fragment.OrderFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends FragmentActivity implements OnClickListener {
	// private FrameLayout fl_main;
	private LinearLayout ll_home;
	private LinearLayout ll_order;
	private LinearLayout ll_me;
	private ImageView iv_home;
	private ImageView iv_order;
	private ImageView iv_me;

	private HomeFragment homefragment = new HomeFragment();
	private OrderFragment orderfragment = new OrderFragment();
	private MeFragment mefragment = new MeFragment();
	private CategroyFragment categroyfragment = new CategroyFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// fl_main=(FrameLayout) this.findViewById(R.id.fl_main);
		ll_home = (LinearLayout) findViewById(R.id.ll_home);
		ll_home.setOnClickListener(this);
		iv_home = (ImageView) findViewById(R.id.iv_home);

		ll_order = (LinearLayout) findViewById(R.id.ll_order);
		ll_order.setOnClickListener(this);
		iv_order = (ImageView) findViewById(R.id.iv_order);

		ll_me = (LinearLayout) findViewById(R.id.ll_me);
		ll_me.setOnClickListener(this);
		iv_me = (ImageView) findViewById(R.id.iv_me);
		changeFragment(homefragment, "homeFragment");
	}

	private void changeFragment(Fragment fragment, String tagfragment) {
		// TODO Auto-generated method stub
		FragmentManager fm = this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fl_main, fragment, tagfragment);
		ft.commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		iv_home.setImageResource(R.drawable.m_tab_home_normal);
		iv_order.setImageResource(R.drawable.m_tab_category_normal);
		iv_me.setImageResource(R.drawable.m_tab_my_normal);
		switch (v.getId()) {
		case R.id.ll_home: {
			changeFragment(homefragment, "homeFragment");
			iv_home.setImageResource(R.drawable.m_tab_home_selected);
			break;
		}
		case R.id.ll_order: {
			changeFragment(orderfragment, "categroyFragment");
			iv_order.setImageResource(R.drawable.m_tab_category_selected);
			break;
		}
		case R.id.ll_me: {
			changeFragment(mefragment, "meFragment");
			iv_me.setImageResource(R.drawable.m_tab_my_selected);
			break;
		}

		}
	}

}
