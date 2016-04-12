/**
 * @date:创建时间：2016-1-11上午12:23:42
 * @author:mao
 * 
 */
package com.monkey77.jsonobj;

/**
 * @author mao
 * @time 创建时间 2016-1-11上午12:23:42
 * 
 */
public class Good {
private int id;
	private int num;
	private float price;
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", num=" + num + "]";
	}
	
	
}
