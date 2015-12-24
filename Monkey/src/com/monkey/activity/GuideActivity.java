package com.monkey.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.monkey.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GuideActivity extends BaseActivity implements OnClickListener {
	private List<ImageView> imgs = new ArrayList<ImageView>();
	private ViewPager vp_imgs;
	private ImageView iv_btn_Tiyan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		// “体验”按钮进入主界面
		iv_btn_Tiyan = (ImageView) findViewById(R.id.iv_btn_Tiyan);
		iv_btn_Tiyan.setOnClickListener(this);
		//初始换imgs列表
		initDatas();
		vp_imgs = (ViewPager) findViewById(R.id.vp_guide_pics);
		//给viewpager添加适配器
		vp_imgs.setAdapter(new MyAdapter());
		vp_imgs.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				if (position == 3) {
					iv_btn_Tiyan.setOnClickListener(GuideActivity.this);
				} else {
					iv_btn_Tiyan.setVisibility(View.INVISIBLE);
				}
			}

			private void changePoint(int position) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void initDatas() {
		// TODO Auto-generated method stub
		ImageView iv1 = new ImageView(this);
		iv1.setBackgroundResource(R.drawable.guide_page_1);
		ImageView iv2 = new ImageView(this);
		iv2.setBackgroundResource(R.drawable.guide_page_2);
		ImageView iv3 = new ImageView(this);
		iv3.setBackgroundResource(R.drawable.guide_page_3);
		ImageView iv4 = new ImageView(this);
		iv4.setBackgroundResource(R.drawable.guide_page_4);
		imgs.add(iv1);
		imgs.add(iv2);
		imgs.add(iv3);
		imgs.add(iv4);
	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imgs.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			ImageView iv = imgs.get(position);
			container.addView(iv);
			return iv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			ImageView iv = imgs.get(position);
			container.removeView(iv);
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(GuideActivity.this, MainActivity.class);
		startActivity(intent);
	}
}
