package com.monkey.activity;

import com.example.monkey.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.lidroid.xutils.ViewUtils;
import com.monkey.fragment.CategroyFragment;
import com.monkey.fragment.HomeFragment;
import com.monkey.fragment.MeFragment;
import com.monkey.fragment.OrderFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends SlidingFragmentActivity implements
		OnClickListener {
	// private FrameLayout fl_main;
	private LinearLayout ll_home;
	private LinearLayout ll_order;
	private LinearLayout ll_me;
	private ImageView iv_home;
	private ImageView iv_order;
	private ImageView iv_me;
    private SlidingMenu slidingMenu;
	private HomeFragment homefragment ;// 首页
	private OrderFragment orderfragment = new OrderFragment();// 订单
	private MeFragment mefragment = new MeFragment();// 我
	private CategroyFragment categroyfragment = new CategroyFragment();// 侧滑菜单-分类

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setBehindContentView(R.layout.framelayout_sildingmenu);
		setContentView(R.layout.main);
		ViewUtils.inject(this);
		// 获得侧滑菜单对象
		slidingMenu= getSlidingMenu();
		homefragment = new HomeFragment(slidingMenu);
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.fl_sildingmenu, categroyfragment).commit();
		// 设置侧滑菜单的宽度
		slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_offset);
		// 设置侧滑菜单的分隔线
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		// 设置侧滑菜单分隔线的大小
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		// 设置侧滑菜单的触动模式
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// 设置侧滑出现的地方
		slidingMenu.setMode(SlidingMenu.LEFT);
		// 初始化左边菜单的数据
		
	
		
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
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
			break;
		}
		case R.id.ll_order: {
			changeFragment(orderfragment, "categroyFragment");
			iv_order.setImageResource(R.drawable.m_tab_category_selected);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
			break;
		}
		case R.id.ll_me: {
			changeFragment(mefragment, "meFragment");
			iv_me.setImageResource(R.drawable.m_tab_my_selected);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
			break;
		}

		}
	}

}
