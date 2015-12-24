package com.monkey.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.monkey.R;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ShowdetailsActivity extends BaseActivity implements OnClickListener{
	private List<ImageView> imgs = new ArrayList<ImageView>();
	private ViewPager vp_fruitDetail;
	private LinearLayout ll_fruitDetail_points;//���Сͼ������Բ���
	private List<ImageView> points = new ArrayList<ImageView>();//���Сͼ��ļ���

	@Override
	protected void onCreate(Bundle savedInstanceState){
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acivity_showdetails);
		
		// ��ʼ��imgs����
		InitDatas();
		// viewPager��������
		vp_fruitDetail = (ViewPager) findViewById(R.id.vp_fruitDetail);
		vp_fruitDetail.setAdapter(new fruitDetailAdapter());
		//��ViewPager��ӻ�������
		vp_fruitDetail.setOnPageChangeListener(new OnPageChangeListener() {
			//��viewPager��ĳ�����汻ѡ��ʱ����
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				changePoint(position);
			}
			//viewPager�ڻ���ʱ������
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			//viewPager����״̬�Ķ�ʱ������
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//����Сͼ��
		ll_fruitDetail_points = (LinearLayout) findViewById(R.id.ll_fruitDetail_points);
		InitPoints();
		
	}
	//��ʼ��imgs
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
	//��ʼ��Сͼ��
		public void InitPoints(){
			for(int i=0; i<imgs.size(); i++){
				ImageView iv_point = new ImageView(this);
				if(i==0){
					iv_point.setBackgroundResource(R.drawable.page_control_on);
				}else{
					iv_point.setBackgroundResource(R.drawable.page_control_off);
				}
			//����Сͼ��֮��ļ��
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 0, 5, 0);//���ñ߾�
			iv_point.setLayoutParams(params);
			iv_point.setId(i);//����point��id
			points.add(iv_point);//��ÿ��Сͼ��ӽ�points����
			ll_fruitDetail_points.addView(iv_point);//��ÿ��Сͼ��ӽ����Բ�����
			}
			
		}
	
		//�ı�Сͼ��ͼƬ
		private void changePoint(int position){
			for(ImageView iv:points){
				iv.setBackgroundResource(R.drawable.page_control_off);
			}
			points.get(position).setBackgroundResource(R.drawable.page_control_on);
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	
}
