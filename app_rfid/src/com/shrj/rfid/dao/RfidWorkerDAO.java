package com.shrj.rfid.dao;

import java.util.List;

import com.shrj.rfid.model.RfidWorker;

public class RfidWorkerDAO extends BaseDBDAO<RfidWorker>{
	public List<RfidWorker> getAllWorkers(){
		String hql = "from RfidWorker";
		return doQueryEntityList(hql);
	}
}
