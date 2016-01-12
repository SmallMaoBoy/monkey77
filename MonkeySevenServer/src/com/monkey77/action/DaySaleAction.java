package com.monkey77.action;

import java.util.Map;


import com.monkey77.service.IDaySaleService;
import com.opensymphony.xwork2.Action;

public class DaySaleAction {
	 private IDaySaleService daysaleService;
	 private Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public IDaySaleService getDaysaleService() {
		return daysaleService;
	}

	public void setDaysaleService(IDaySaleService daysaleService) {
		this.daysaleService = daysaleService;
	}

	public String getDaySale(){
		map=daysaleService.getDaySale();
	    return Action.SUCCESS;
	}

}
