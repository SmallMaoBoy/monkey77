package com.monkey.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.monkey.R;

public class ShowdetailsActivity extends Activity implements OnClickListener {
	private boolean isLoop = true;
	private List<ImageView> imgs = new ArrayList<ImageView>();
	private ViewPager vp_fruitDetail;
	private LinearLayout ll_fruitDetail_points;// ���Сͼ������Բ���
	private List<ImageView> points = new ArrayList<ImageView>();// ���Сͼ��ļ���
	private EditText et_am;//������
	private ImageView iv_add;
	private ImageView iv_minus;
	private ImageView iv_showDetali_share;
	private TextView tv_addToCar;
	private ImageView iv_anim;
	private ImageView iv_showDetali_shoppingCar;
	private ImageView iv_sign;
	private TextView tv_num;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			if (vp_fruitDetail.getCurrentItem() <= 2) {
				vp_fruitDetail
						.setCurrentItem(vp_fruitDetail.getCurrentItem() + 1);
			} else {
				vp_fruitDetail.setCurrentItem(0);
			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acivity_showdetails);
		// 1�� ����viewpager
		setViewPager();
		// 2�������������������
		et_am = (EditText) findViewById(R.id.et_am);
		setAmEdittext();
		//3�����÷�����
		setShare();
		//4�����빺�ﳵ��ť
		
		iv_showDetali_shoppingCar = (ImageView) findViewById(R.id.iv_showDetali_shoppingCar);		
		setAddToCar();
		judgeCarNum();

	}

	// 1�� ����viewpager
	public void setViewPager() {

		// ��ʼ��imgs����
		InitDatas();

		// viewPager��������
		vp_fruitDetail = (ViewPager) findViewById(R.id.vp_fruitDetail);
		vp_fruitDetail.setAdapter(new fruitDetailAdapter());

		// ��ʱ�л�ѭ��ͼƬ
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (isLoop) {
					SystemClock.sleep(2000);
					handler.sendEmptyMessage(0);
				}
			}
		}).start();

		// ��ViewPager��ӻ�������
		vp_fruitDetail.setOnPageChangeListener(new OnPageChangeListener() {
			// ��viewPager��ĳ�����汻ѡ��ʱ����
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				changePoint(position);// �ı�Сͼ��
			}

			// viewPager�ڻ���ʱ������
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			// viewPager����״̬�Ķ�ʱ������
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		// ����Сͼ��
		ll_fruitDetail_points = (LinearLayout) findViewById(R.id.ll_fruitDetail_points);
		InitPoints();
	}

	// ��ʼ��imgs
	public void InitDatas() {
		ImageView img1 = new ImageView(this);
		ImageView img2 = new ImageView(this);
		ImageView img3 = new ImageView(this);
		ImageView img4 = new ImageView(this);
		img1.setBackgroundResource(R.drawable.f10);
		img2.setBackgroundResource(R.drawable.f11);
		img3.setBackgroundResource(R.drawable.f12);
		img4.setBackgroundResource(R.drawable.f13);
		imgs.add(img1);
		imgs.add(img2);
		imgs.add(img3);
		imgs.add(img4);
	}

	class fruitDetailAdapter extends PagerAdapter {

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

		// ��viewPager���������Ӷ�Ӧ����ͼ����
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			ImageView iv = imgs.get(position);
			container.addView(iv);
			return iv;
		}

		// ��viewPager������ɾ����Ӧ����ͼ����
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			ImageView iv = imgs.get(position);
			container.removeView(iv);
		}

	}

	// ��ʼ��Сͼ��
	public void InitPoints() {
		for (int i = 0; i < imgs.size(); i++) {
			ImageView iv_point = new ImageView(this);
			if (i == 0) {
				iv_point.setBackgroundResource(R.drawable.page_control_on);
			} else {
				iv_point.setBackgroundResource(R.drawable.page_control_off);
			}
			// ����Сͼ��֮��ļ��
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 0, 5, 0);// ���ñ߾�
			iv_point.setLayoutParams(params);
			iv_point.setId(i);// ����point��id
			points.add(iv_point);// ��ÿ��Сͼ��ӽ�points����
			ll_fruitDetail_points.addView(iv_point);// ��ÿ��Сͼ��ӽ����Բ�����
		}

	}

	// �ı�Сͼ��ͼƬ
	private void changePoint(int position) {
		for (ImageView iv : points) {
			iv.setBackgroundResource(R.drawable.page_control_off);
		}
		points.get(position).setBackgroundResource(R.drawable.page_control_on);
	}

	// ---------------------------------------
	// 2�������������������
	public void setAmEdittext() {
		iv_add = (ImageView) findViewById(R.id.iv_add);
		iv_add.setOnClickListener(this);
		iv_minus = (ImageView) findViewById(R.id.iv_minus);
		iv_minus.setOnClickListener(this);
	}
	
	//----------------------------------------
	//3�����÷�����
	public void setShare(){
		iv_showDetali_share = (ImageView) findViewById(R.id.iv_showDetali_share);
		iv_showDetali_share.setOnClickListener(this);		
	};
	
	public void share(Context context, String activityTitle, String msgTitle, String msgText, 
			String imgPath){
		Intent intent = new Intent(Intent.ACTION_SEND); 
		if (imgPath == null || imgPath.equals("")) { 
		intent.setType("text/plain"); // ���ı� 
		} else { 
		File f = new File(imgPath); 
		if (f != null && f.exists() && f.isFile()) { 
		intent.setType("image/png"); 
		Uri u = Uri.fromFile(f); 
		intent.putExtra(Intent.EXTRA_STREAM, u); 
		} 
		} 
		intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle); 
		intent.putExtra(Intent.EXTRA_TEXT, msgText); 
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		context.startActivity(Intent.createChooser(intent, activityTitle)); 
	}
	
	//----------------------------------------
	//4�����ﳵ��ť
	public void setAddToCar(){	
		iv_sign = (ImageView) findViewById(R.id.iv_sign);
		iv_sign.setVisibility(View.GONE);
		tv_num = (TextView) findViewById(R.id.tv_num);
		tv_num.setVisibility(View.GONE);
		tv_addToCar = (TextView) findViewById(R.id.tv_addToCar);
		tv_addToCar.setOnClickListener(this);		
	}
	public void judgeCarNum(){
		int currentcarNum = Integer.parseInt(tv_num.getText().toString());
		if(currentcarNum==0){
			iv_sign.setVisibility(View.GONE);
			tv_num.setVisibility(View.GONE);
		}else{
			iv_sign.setVisibility(View.VISIBLE);
			tv_num.setVisibility(View.VISIBLE);
		}
	}
	//����������
	public void addToCar(){
		int updatecarnum = Integer.parseInt(tv_num.getText().toString());
		int currentcarNum = Integer.parseInt(et_am.getText().toString());
		if(updatecarnum==0){
			tv_num.setText(String.valueOf(currentcarNum));	
		}else{
			tv_num.setText(String.valueOf(Integer.parseInt(tv_num.getText().toString())+currentcarNum));
		}
		iv_sign.setVisibility(View.VISIBLE);
		tv_num.setVisibility(View.VISIBLE);
	}
	//----------------------------------------
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String num = null;
		int currentNum = -1;
		switch (v.getId()) {
		case R.id.iv_add:
			currentNum = Integer.parseInt(et_am.getText().toString());
			if(currentNum<999){
				num = String.valueOf(currentNum+1);
				et_am.setText(num);
				et_am.setSelection(num.length());
			}
			
			break;
			
		case R.id.iv_minus:
			currentNum = Integer.parseInt(et_am.getText().toString());
			if(currentNum>=2){
				num = String.valueOf(currentNum-1);
				et_am.setText(num);
				et_am.setSelection(num.length());
			}			
			break;
			
		case R.id.iv_showDetali_share:
			share(this,"������","�츻ʿƻ��","https://www.baidu.com/","");
			break;
			
		case R.id.tv_addToCar:
			addToCar();
			break;
			
		default:
			break;
		}
	}

}
