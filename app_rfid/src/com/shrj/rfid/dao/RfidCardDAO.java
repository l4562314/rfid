package com.shrj.rfid.dao;

import java.util.List;

import com.shrj.rfid.model.RfidCard;

public class RfidCardDAO extends BaseDBDAO<RfidCard>{
	public List<RfidCard> getAllCards(){
		String hql = "from RfidCard";
		return doQueryEntityList(hql);
	}
}
