/**
 * @date:创建时间：2015-12-28下午3:18:57
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TShowPic;

/**
 * @author mao
 * @time 创建时间 2015-12-28下午3:18:57
 * 
 */
public class TShowPicImp extends HibernateDaoSupport implements ITShowPicDao{

	/**
	 * @author mao
	 * @date 创建时间：2015-12-28下午3:19:17
	 * @see com.monkey77.dao.ITShowPicDao#createNewPic(com.monkey77.entities.TShowPic)
	 */
	@Override
	public void createNewPic(TShowPic showPic) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(showPic);
	}

	/**
	 * @author mao
	 * @date 创建时间：2015-12-28下午3:19:17
	 * @see com.monkey77.dao.ITShowPicDao#getAllTShowPicList()
	 */
	@Override
	public List<TShowPic> getAllTShowPicList() {
		// TODO Auto-generated method stub
		List<TShowPic> list=this.getHibernateTemplate().find("from TShowPic");
		return list;
	}

}
