package com.monkey.pojo;

public class Item_gvmsg {
	int pic;
	String title;
	String price;
	public Item_gvmsg(int pic, String title, String price) {
		super();
		this.pic = pic;
		this.title = title;
		this.price = price;
	}
	public int getPic() {
		return pic;
	}
	public void setPic(int pic) {
		this.pic = pic;
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
