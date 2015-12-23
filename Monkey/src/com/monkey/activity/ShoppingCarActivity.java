package com.monkey.activity;

import com.example.monkey.R;
import com.monkey.fragment.ShoppingcarLoginNullFragment;
import com.monkey.fragment.ShoppingcarUnloginFragment;
import com.monkey.threads.ShoppingCarActivityThread;
import com.monkey.utils.XmlUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ShoppingCarActivity extends FragmentActivity implements OnClickListener{
	private ShoppingcarUnloginFragment shoppingcar_unlogin_fragment = new ShoppingcarUnloginFragment();
	private ShoppingcarLoginNullFragment shoppingcar_login_null_fragment = new ShoppingcarLoginNullFragment();
	//private FrameLayout fl_shoppingcar;
	//private TextView tv_shoppingcar_unlogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shoppingcar);
		//Thread thread = new Thread(new ShoppingCarActivityThread());
		//thread.start();
		//读取user.xml文件是否存在、用户是否登录,并切换fragment.
		checkToWhichFragment();
	}
	private void checkToWhichFragment() {
		// TODO Auto-generated method stub
		String userName = XmlUtils.readStringData(this, "user", "userName");
		if(userName==""){
			changeFragment(shoppingcar_unlogin_fragment, "shoppingcar_unlogin_fragment");
		}else{
			changeFragment(shoppingcar_login_null_fragment, "shoppingcar_login_null_fragment");
		}
	}
	private void changeFragment(Fragment fragment, String tagfragment) {
		// TODO Auto-generated method stub
		FragmentManager fm = this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fl_shoppingCar, fragment, tagfragment);
		ft.commit();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
