package com.monkey.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.monkey.R;
import com.monkey.pojo.CategroyItem;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CategroyFragment extends Fragment {
	private View view;
	private ListView lv_categroy;
	private String[] names = new String[] { "Æ»¹û", "Ïã½¶", "Àæ", "¹ÏÀà", "¸Ì¡¢½Û¡¢³È",
			"Ã¢¹û", "»ðÁú¹û", "²ÝÝ®¡¢À¶Ý®", "²¤ÂÜ", "ÆæÒì¹û", "èÖ×Ó", "Ã¢¹û", "Ó£ÌÒ",
			"Ôæ", "ÁñÁ«", "ÆäËû" };
	private int[] pics = new int[] { R.drawable.icon_home_title,
			R.drawable.icon_home_title, R.drawable.icon_home_title,
			R.drawable.icon_home_title, R.drawable.icon_home_title,
			R.drawable.icon_home_title, R.drawable.icon_home_title,
			R.drawable.icon_home_title, R.drawable.icon_home_title,
			R.drawable.icon_home_title, R.drawable.icon_home_title,
			R.drawable.icon_home_title, R.drawable.icon_home_title,
			R.drawable.icon_home_title, R.drawable.icon_home_title,
			R.drawable.icon_home_title
			};
	private List<CategroyItem> categroy_items = new ArrayList<CategroyItem>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_categroy, container, false);
		lv_categroy = (ListView) view.findViewById(R.id.lv_categroy);
		initData();
		lv_categroy.setAdapter(new CateAdapter());
		return view;
	}

	public void initData() {
		for (int i = 0; i < names.length; i++) {
			CategroyItem categroy_item = new CategroyItem(pics[i], names[i]);
			categroy_items.add(categroy_item);
		}
	}

	class CateAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return categroy_items.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return categroy_items.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = View.inflate(CategroyFragment.this.getActivity(),
					R.layout.item_categroy, null);
			ImageView iv_item_categroy = (ImageView) view
					.findViewById(R.id.iv_item_categroy);
			TextView tv_item_categroy = (TextView) view
					.findViewById(R.id.tv_item_categroy);
			CategroyItem categroyitem = categroy_items.get(position);
			iv_item_categroy.setImageResource(categroyitem.getPic());
			tv_item_categroy.setText(categroyitem.getCategroy_name());
			return view;
		}

	}
}
