package com.monkey.json;

import java.util.ArrayList;
import java.util.List;

public class GoodMsg {
	private String account;
	private List<Good> goods=new ArrayList<Good>();
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public List<Good> getGoods() {
		return goods;
	}
	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

}
