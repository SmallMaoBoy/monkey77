package com.monkey.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.example.monkey.R;
import com.example.monkey.R.drawable;
import com.example.monkey.R.id;
import com.example.monkey.R.layout;
import com.monkey.activity.ActivityShowdetails;
import com.monkey.pojo.Item_gvmsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment implements OnClickListener {

	private View view;
	private GridView gv;
	private TextView  categroy;
	private ImageView iv_shopping_car;
	// private int mywidth;
	// private int myheight;
	private int[] pics = new int[] { R.drawable.f1, R.drawable.f2,
			R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6,
			R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10,
			R.drawable.f11, R.drawable.f12, R.drawable.f13, R.drawable.f14,
			R.drawable.f15, R.drawable.f16, R.drawable.f17, };
	private String[] titles = new String[] { "»ÆÌÒ", "ºìèÖ×Ó", "Ó£ÌÒ", "ÆæÒì¹û", "Î÷¹Ï",
			"Ã¢¹û", "ÇàÆ»¹û", "²ÝÝ®", "ÄûÃÊ", "É£é©", "É½Öñ", "ÆÏÌÑ", "Ïã½¶", "ÁñÁ«", "Î÷Ã·", "Ê¯Áñ",
			"»ðÁú¹û" };
	private String[] prices = new String[] { "10.3", "11", "5", "23", "5.9",
			"7.6", "35.2", "9.9", "20.5", "6", "5", "23", "5.9", "7.6", "35.2",
			"9.9", "20.5", "6" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		view = inflater.inflate(R.layout.home_fragment, container, false);
		categroy = (TextView) view.findViewById(R.id.categroy);
		categroy.setOnClickListener(this);
		iv_shopping_car = (ImageView) view.findViewById(R.id.iv_shopping_cart);
		iv_shopping_car.setOnClickListener(this);
		// WindowManager wm = getActivity().getWindowManager();//»ñÈ¡ÆµÄ»´óÐ¡
		// Display display = wm.getDefaultDisplay();
		// mywidth = display.getWidth();
		// myheight = display.getHeight();
		gv = (GridView) view.findViewById(R.id.gv_home_pics);
		gv.setAdapter(new MygvAdapter(pics, titles, prices));// Ìí¼ÓÊÊÅäÆ÷
		gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						ActivityShowdetails.class);
				startActivity(intent);
			}
		});
		return view;
	}

	class MygvAdapter extends BaseAdapter {
		private List<Item_gvmsg> Items;

		public MygvAdapter() {
			// TODO Auto-generated constructor stub
		}

		public MygvAdapter(int[] pics, String[] titles, String[] prices) {
			// TODO Auto-generated method stub
			Items = new ArrayList<Item_gvmsg>();
			for (int i = 0; i < pics.length; i++) {
				Item_gvmsg item = new Item_gvmsg(pics[i], titles[i], prices[i]);
				Items.add(item);
			}
		}

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
			return position;
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
			msg_pic.setImageResource(item_gvmsg.getPic());
			msg_title.setText(item_gvmsg.getTitle());
			msg_price.setText(item_gvmsg.getPrice());
			return view;
		}
	}

	/*
	 * @Override public void onClick(View v) { // TODO Auto-generated method
	 * stub switch (v.getId()) {
	 * 
	 * case R.id.iv_shopping_cart: Toast.makeText(getActivity(),
	 * "hahaahahhahah",Toast.LENGTH_SHORT).show(); break; } }
	 */
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
		switch (v.getId()) {
		case R.id.categroy:
			CategroyFragment categroyfragment = new CategroyFragment();
			changeFragment(categroyfragment, "categroyfragment");
			 Toast.makeText(getActivity(),
			"Ä¬ÈÏToastÑùÊ½",Toast.LENGTH_SHORT).show();
			break;
		}

	}
}
