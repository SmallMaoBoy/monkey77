/**
 * @date:创建时间：2016-1-2下午11:25:07
 * @author:mao
 * 
 */
package com.monkey77.jsonobj;

/**
 * @author mao
 * @time 创建时间 2016-1-2下午11:25:07
 * 
 */
public class JsonCart {
	private String name;
	private int num;
	private Float price;
	private String specification;
	private String picUrl;
	private Float totalPrice;
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public JsonCart() {
		super();
	}
	public JsonCart(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "JsonCart [name=" + name + ", num=" + num + ", price=" + price
				+ ", specification=" + specification + ", picUrl=" + picUrl
				+ ", totalPrice=" + totalPrice + "]";
	}
	
}
