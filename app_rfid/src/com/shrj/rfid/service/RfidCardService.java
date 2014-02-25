package com.shrj.rfid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shrj.rfid.admin.dao.ManageChannelDAO;
import com.shrj.rfid.admin.dao.ManageNodeDAO;
import com.shrj.rfid.admin.dao.ManageUserDAO;
import com.shrj.rfid.admin.model.ManageChannel;
import com.shrj.rfid.admin.model.ManageNode;
import com.shrj.rfid.admin.model.ManageUser;
import com.shrj.rfid.dao.RfidCardDAO;
import com.shrj.rfid.dao.RfidWorkerDAO;
import com.shrj.rfid.model.RfidCard;
import com.shrj.rfid.model.RfidWorker;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:10
 */
public class RfidCardService {
    private RfidCardDAO rfidCardDAO;

    public List<RfidCard> getAllCards(){
    	return rfidCardDAO.getAllCards();
    }
    
    public RfidCard getCard(long id){
    	return rfidCardDAO.get(id);
    }
    
    @Transactional
    public void saveCard(RfidCard card){
    	rfidCardDAO.saveOrUpdate(card);;
    }
    
    @Transactional
    public void delete(long id) {
    	rfidCardDAO.delete(id);
	}

	public void setRfidCardDAO(RfidCardDAO rfidCardDAO) {
		this.rfidCardDAO = rfidCardDAO;
	}
}
