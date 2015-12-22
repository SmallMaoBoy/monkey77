package com.monkey77.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.monkey77.entities.TSmsIdentifyingCode;

public class TSmsIdentifyingCodeDaoImp extends HibernateDaoSupport implements ITSmsIdentifyingCodeDao {

	@Override
	public void saveOrUpdateIdentifyingCode(TSmsIdentifyingCode indetifyingCode) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(indetifyingCode);
	}

	@Override
	public String getIdentifyCode(String mobile) {
		// TODO Auto-generated method stub
		List<TSmsIdentifyingCode> list=this.getHibernateTemplate().find("from TSmsIdentifyingCode t where t.mobile="+mobile);
		return list.isEmpty()==true?null:list.get(list.size()-1).getIdentifyingCode();
	}

}
