package com.monkey.pojo;

public class CategroyItem {
	private int pic;
	private String categroy_name;
	public int getPic() {
		return pic;
	}
	public void setPic(int pic) {
		this.pic = pic;
	}
	public String getCategroy_name() {
		return categroy_name;
	}
	public void setCategroy_name(String categroy_name) {
		this.categroy_name = categroy_name;
	}
	public CategroyItem(int pic, String categroy_name) {
		super();
		this.pic = pic;
		this.categroy_name = categroy_name;
	}
	public CategroyItem() {
		super();
	}

}
