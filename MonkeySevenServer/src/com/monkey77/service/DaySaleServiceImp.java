/**
 * @date:创建时间：2016-1-11上午12:02:28
 * @author:mao
 * 
 */
package com.monkey77.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.monkey77.dao.ITDaySaleDao;
import com.monkey77.dao.ITGoodDao;
import com.monkey77.dao.ITOrderDetailDao;
import com.monkey77.entities.TDaySale;
import com.monkey77.entities.TGood;
import com.monkey77.jsonobj.Good;

/**
 * @author mao
 * @time 创建时间 2016-1-11上午12:02:28
 * 
 */
public class DaySaleServiceImp implements IDaySaleService {

	private ITDaySaleDao daySaleDao;
	private ITOrderDetailDao orderDetailDao;
	private ITGoodDao goodDao;
	
	
	public ITGoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(ITGoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public ITDaySaleDao getDaySaleDao() {
		return daySaleDao;
	}

	public void setDaySaleDao(ITDaySaleDao daySaleDao) {
		this.daySaleDao = daySaleDao;
	}

	public ITOrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	public void setOrderDetailDao(ITOrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	/**
	 * @author mao
	 * @date 创建时间：2016-1-11上午12:02:39
	 * @see com.monkey77.service.IDaySaleService#addDaySale(int)
	 */
	@Override
	public void addDaySale(int orderId) {
		// TODO Auto-generated method stub
		List<Good> goods = orderDetailDao.getGoodsByOrderId(orderId);
		Calendar c = Calendar.getInstance();
		// 从一个 Calendar 对象中获取 Date 对象
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		Date d = c.getTime();
		List<TDaySale> sales = daySaleDao.getDaySale(d);

		for (Good g : goods) {
			boolean flag = true;
			for (TDaySale t : sales) {
				if (g.getId() == t.getTGood().getId()) {
					t.setNum(t.getNum() + g.getNum());
					daySaleDao.createOrUpdate(t);
					flag = false;
					break;
				}
			}
			if (flag) {

				TDaySale t = new TDaySale();
				t.setNum(g.getNum());
				t.setSaleDate(new Date());
				t.setTGood(new TGood(g.getId()));
				daySaleDao.createOrUpdate(t);
			}
		}
	}

	@Override
	public void calculateDaySell() {
		// TODO Auto-generated method stub
		//设置一个日历
	}
	/**
	 * @author mao
	 * @date 创建时间：2016-1-11下午10:44:01
	 * @see com.monkey77.service.IDaySaleService#getDaySale()
	 */
	@Override
	public Map<String, Object> getDaySale() {
		// TODO Auto-generated method stub
		Map<String, Object> result=new HashMap<String, Object>();
		Calendar c = Calendar.getInstance();
		// 从一个 Calendar 对象中获取 Date 对象
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		Date d = c.getTime();
		List<TDaySale> sales = daySaleDao.getDaySale(d);
		for(TDaySale t:sales){
			result.put(goodDao.getGoodNameById(t.getTGood().getId()), t.getNum());
		}
		return result;
	}

}
