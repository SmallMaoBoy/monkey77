package com.monkey.fragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.monkey.R;
import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.monkey.activity.ShoppingCarActivity;
import com.monkey.activity.ShowdetailsActivity;
import com.monkey.json.Good;
import com.monkey.json.GoodMsg;
import com.monkey.pojo.Item_gvmsg;
import com.monkey.service.HomeService;
import com.monkey.utils.PropertiesUtil;

public class HomeFragment extends Fragment implements OnClickListener {

	private View view;
	private GridView gv;
	private TextView categroy;
	private ImageView iv_shopping_car;
	private List<Item_gvmsg> Items;
	private SlidingMenu slidingMenu;
	private ImageButton btn_car;
	private MygvAdapter gvAdapter;
	private Bitmap bitmap;

	public HomeFragment(SlidingMenu slidingMenu) {
		super();
		this.slidingMenu = slidingMenu;
	}

	private Handler handler = new Handler() {// ui线程做的事
		public void handleMessage(android.os.Message msg) {
			int type = (int) msg.getData().get("type");
			switch (type) {
			case 1:
				Gson gson = new Gson();
				GoodMsg goodmsg = gson.fromJson(msg.getData().get("result")
						.toString(), GoodMsg.class);
				List<Good> goods = goodmsg.getGoods();
				for (int i = 0; i < goods.size(); i++) {
					Item_gvmsg item = new Item_gvmsg(bitmap, goods.get(i)
							.getName(), String.valueOf(goods.get(i).getPrice()));
					Items.add(item);
					new GetPicThread(i, PropertiesUtil.getValue("BaseUrl")
							+ goods.get(i).getPicUrl()).start();
					Log.d("maomao", goods.get(i).getName());

				}

				gvAdapter.notifyDataSetChanged();
				break;
			case 2:
				gvAdapter.notifyDataSetChanged();
				break;
			}

		}

	};

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

		gv = (GridView) view.findViewById(R.id.gv_home_pics);
		initData();
		gvAdapter = new MygvAdapter();
		gv.setAdapter(gvAdapter);// 添加适配器
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
		// 從網絡獲取數據，放到gridview
		return view;
	}

	public void initData() {
		Items = new ArrayList<Item_gvmsg>();
		HomeService homeService = new HomeService(handler);
		homeService.getGoods();
	}

	// gridview适配器
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
			ImageView msg_pic = (ImageView) view
					.findViewById(R.id.item_gvmsg_pic);
			TextView msg_title = (TextView) view
					.findViewById(R.id.item_gvmsg_title);
			TextView msg_price = (TextView) view
					.findViewById(R.id.item_gvmsg_price);
			Item_gvmsg item_gvmsg = Items.get(position);
			msg_pic.setBackground(item_gvmsg.getDrawable());
			msg_title.setText(item_gvmsg.getTitle());
			msg_price.setText(item_gvmsg.getPrice());
			return view;
		}
	}

	// 点击事件
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
			intent = new Intent(this.getActivity(), ShoppingCarActivity.class);
			startActivity(intent);
			Toast.makeText(getActivity(), "hahhahahaha", Toast.LENGTH_SHORT)
					.show();
			break;
		}

	}

	// 根据URL获取图片线程
	class GetPicThread extends Thread {

		public GetPicThread(int num, String picUrl) {
			super();
			this.num = num;
			this.picUrl = picUrl;
		}

		private int num;
		private String picUrl;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();

			Drawable d = loadImageFromNetwork(picUrl);
			Items.get(num).setDrawable(d);
			Message message = new Message();
			Bundle b = new Bundle();
			b.putInt("type", 2);
			message.setData(b);
			handler.sendMessage(message);
		}

		public Drawable loadImageFromNetwork(String imageUrl) {
			// TODO Auto-generated method stub
			Drawable drawable = null;
			try {
				// 可以在这里通过文件名来判断，是否本地有此图片
				drawable = Drawable.createFromStream(
						new URL(imageUrl).openStream(), "image.jpg");
			} catch (IOException e) {
				Log.d("test", e.getMessage());
			}
			if (drawable == null) {
				Log.d("test", "null drawable");
			} else {
				Log.d("test", "not null drawable");
			}

			return drawable;

		}
	}
}
