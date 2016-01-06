package com.monkey.pojo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Item_gvmsg {
	Bitmap bitmap;
	String title;
	String price;
	Drawable drawable;
	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public Item_gvmsg(Bitmap bitmap, String title, String price,
			Drawable drawable) {
		super();
		this.bitmap = bitmap;
		this.title = title;
		this.price = price;
		this.drawable = drawable;
	}

	public Item_gvmsg(Bitmap bitmap, String title, String price) {
		super();
		this.bitmap = bitmap;
		this.title = title;
		this.price = price;
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
