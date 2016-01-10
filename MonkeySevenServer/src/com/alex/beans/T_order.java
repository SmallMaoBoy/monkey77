package com.alex.beans;

import java.sql.Time;

public class T_order {
   private int id;
   private String status;
   private float total_price;
   private String remarks;
   private Time generated_time;
   private Time pay_time;
   private Time take_time;
   private int shop_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public float getTotal_price() {
	return total_price;
}
public void setTotal_price(float total_price) {
	this.total_price = total_price;
}
public String getReamarks() {
	return remarks;
}
public void setReamarks(String reamarks) {
	this.remarks = reamarks;
}
public Time getGenerated_time() {
	return generated_time;
}
public void setGenerated_time(Time generated_time) {
	this.generated_time = generated_time;
}
public Time getPay_time() {
	return pay_time;
}
public void setPay_time(Time pay_time) {
	this.pay_time = pay_time;
}
public Time getTake_time() {
	return take_time;
}
public void setTake_time(Time take_time) {
	this.take_time = take_time;
}
public int getShop_id() {
	return shop_id;
}
public void setShop_id(int shop_id) {
	this.shop_id = shop_id;
}

}
