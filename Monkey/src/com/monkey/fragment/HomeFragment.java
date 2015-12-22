package com.monkey.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.monkey.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.monkey.activity.ShoppingCarActivity;
import com.monkey.activity.ShowdetailsActivity;
import com.monkey.pojo.Item_gvmsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment implements OnClickListener {

	private View view;
	private GridView gv;
	private TextView categroy;
	private ImageView iv_shopping_car;
	private List<Item_gvmsg> Items;
	private SlidingMenu slidingMenu;
	private ImageButton btn_car;
	// private int mywidth;
	// private int myheight;
	private int[] pics = new int[] { R.drawable.f1, R.drawable.f2,
			R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6,
			R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10,
			R.drawable.f11, R.drawable.f12, R.drawable.f13, R.drawable.f14,
			R.drawable.f15, R.drawable.f16, R.drawable.f17, };

	public HomeFragment(SlidingMenu slidingMenu) {
		super();
		this.slidingMenu = slidingMenu;
	}

	private String[] titles = new String[] { "黄桃", "红柚子", "樱桃", "奇异果", "西瓜",
			"芒果", "青苹果", "草莓", "柠檬", "桑椹", "山竹", "葡萄", "香蕉", "榴莲", "西梅", "石榴",
			"火龙果" };
	private String[] prices = new String[] { "10.3", "11", "5", "23", "5.9",
			"7.6", "35.2", "9.9", "20.5", "6", "5", "23", "5.9", "7.6", "35.2",
			"9.9", "20.5", "6" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		view = inflater.inflate(R.layout.fragment_home, container, false);
		categroy = (TextView) view.findViewById(R.id.categroy);
		categroy.setOnClickListener(this);
		iv_shopping_car = (ImageView) view.findViewById(R.id.iv_shopping_cart);
		iv_shopping_car.setOnClickListener(this);
		// WindowManager wm = getActivity().getWindowManager();//获取频幕大小
		// Display display = wm.getDefaultDisplay();
		// mywidth = display.getWidth();
		// myheight = display.getHeight();
		gv = (GridView) view.findViewById(R.id.gv_home_pics);
		initData();
		gv.setAdapter(new MygvAdapter());// 添加适配器
		gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						ShowdetailsActivity.class);
				startActivity(intent);
			}
		});
		// 设置购物车按钮点击事件
		btn_car = (ImageButton) view.findViewById(R.id.btn_car);
		btn_car.setOnClickListener(this);
		return view;
	}

	public void initData() {
		Items = new ArrayList<Item_gvmsg>();
		for (int i = 0; i < pics.length; i++) {
			Item_gvmsg item = new Item_gvmsg(pics[i], titles[i], prices[i]);
			Items.add(item);
		}
	}

	class MygvAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if (Items != null) {
				return Items.size();
			} else {
				return 0;
			}
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return Items.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = View.inflate(HomeFragment.this.getActivity(),
					R.layout.item_gvmsg, null);
			LinearLayout ll_gvmsg = (LinearLayout) view
					.findViewById(R.id.ll_gvmsg);
			ImageView msg_pic = (ImageView) view
					.findViewById(R.id.item_gvmsg_pic);
			TextView msg_title = (TextView) view
					.findViewById(R.id.item_gvmsg_title);
			TextView msg_price = (TextView) view
					.findViewById(R.id.item_gvmsg_price);
			Item_gvmsg item_gvmsg = Items.get(position);
			msg_pic.setBackgroundResource(item_gvmsg.getPic());
			msg_title.setText(item_gvmsg.getTitle());
			msg_price.setText(item_gvmsg.getPrice());
			return view;
		}
	}

	private void changeFragment(Fragment fragment, String tagfragment) {
		// TODO Auto-generated method stub
		FragmentManager fm = getActivity().getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fl_main, fragment, tagfragment);
		ft.commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.categroy:
			slidingMenu.showMenu();
			Toast.makeText(getActivity(), "默认Toast样式", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn_car:
			intent = new Intent(this.getActivity(),ShoppingCarActivity.class);
			startActivity(intent);
			Toast.makeText(getActivity(), "hahhahahaha", Toast.LENGTH_SHORT)
			.show();
			break;
		}

	}
}
