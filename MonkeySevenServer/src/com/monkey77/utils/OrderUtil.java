/**
 * @date:创建时间：2016-1-9下午1:54:53
 * @author:mao
 * 
 */
package com.monkey77.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mao
 * @time 创建时间 2016-1-9下午1:54:53
 * 
 */
public class OrderUtil {

	private static long orderNum = 0l;
	private static String date;

	/**
	 * 生成订单编号
	 * 
	 * @return
	 */
	public static synchronized String getOrderNo() {
		String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		if (date == null || !date.equals(str)) {
			date = str;
			orderNum = 0l;
		}
		orderNum++;
		long orderNo = Long.parseLong((date)) * 10000;
		orderNo += orderNum;
		return "MK"+orderNo ;
	}
}
