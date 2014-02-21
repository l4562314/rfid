package com.shrj.rfid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shrj.rfid.admin.dao.ManageChannelDAO;
import com.shrj.rfid.admin.dao.ManageNodeDAO;
import com.shrj.rfid.admin.dao.ManageUserDAO;
import com.shrj.rfid.admin.model.ManageChannel;
import com.shrj.rfid.admin.model.ManageNode;
import com.shrj.rfid.admin.model.ManageUser;
import com.shrj.rfid.dao.RfidWorkerDAO;
import com.shrj.rfid.model.RfidWorker;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:10
 */
public class RfidWorkerService {
    private RfidWorkerDAO rfidWorkerDAO;

    public List<RfidWorker> getAllWorker(){
    	return rfidWorkerDAO.getAllWorkers();
    }
    
    public RfidWorker getWorker(long id) {
		return rfidWorkerDAO.get(id);
	}
    
    @Transactional
    public void saveWorker(RfidWorker worker){
    	rfidWorkerDAO.saveOrUpdate(worker);
    }
    
    @Transactional
    public void delete(long id) {
		rfidWorkerDAO.delete(id);
	}

	public void setRfidWorkerDAO(RfidWorkerDAO rfidWorkerDAO) {
		this.rfidWorkerDAO = rfidWorkerDAO;
	}
}
