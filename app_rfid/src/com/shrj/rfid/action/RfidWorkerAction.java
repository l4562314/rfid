package com.shrj.rfid.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.apache.commons.lang.StringUtils;

import com.shrj.rfid.admin.action.BaseAdminAction;
import com.shrj.rfid.model.RfidWorker;
import com.shrj.rfid.service.RfidWorkerService;

/**
 * User: chjp
 * Date: 11-10-20
 * Time: 上午11:00
 */
@UrlBinding("/worker.do")
public class RfidWorkerAction extends BaseAdminAction {

	private List<RfidWorker> workers;
	@SpringBean
	private RfidWorkerService workerService;
	
	private RfidWorker worker; 
	private String birthday;
	
    @DefaultHandler
    public Resolution list() {
        workers = workerService.getAllWorker();
        return getResolution("worker/list");
    }

    public Resolution form(){
    	if(worker != null && worker.getId() > 0){
    		worker = workerService.getWorker(worker.getId());
    		
    		if(worker.getBirthday() != null){
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    			birthday = sdf.format(worker.getBirthday());
    		}
    	}
    	return getResolution("worker/form");
    }
    
    public Resolution saveWorker(){
    	if(worker.getCreatetime() == null){
    		worker.setCreatetime(new Timestamp(new Date().getTime()));
    	}
    	if(!StringUtils.isEmpty(birthday)){
    		try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				worker.setBirthday(new Timestamp(sdf.parse(birthday).getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	workerService.saveWorker(worker);
    	return new RedirectResolution(getClass());
    }
    
    public Resolution delete(){
    	if(worker != null){
    		workerService.delete(worker.getId());
    	}
    	return new RedirectResolution(getClass());
    }
    
	public List<RfidWorker> getWorkers() {
		return workers;
	}

	public void setWorkerService(RfidWorkerService workerService) {
		this.workerService = workerService;
	}

	public RfidWorker getWorker() {
		return worker;
	}

	public void setWorker(RfidWorker worker) {
		this.worker = worker;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
