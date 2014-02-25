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
import com.shrj.rfid.model.RfidCard;
import com.shrj.rfid.model.RfidWorker;
import com.shrj.rfid.service.RfidCardService;
import com.shrj.rfid.service.RfidWorkerService;

/**
 * User: chjp
 * Date: 11-10-20
 * Time: 上午11:00
 */
@UrlBinding("/card.do")
public class RfidCardAction extends BaseAdminAction {

	private List<RfidCard> cards;
	@SpringBean
	private RfidCardService cardService;
	
	private RfidCard card; 
	
    @DefaultHandler
    public Resolution list() {
        cards = cardService.getAllCards();
        return getResolution("card/list");
    }

    public Resolution form(){
    	if(card != null && card.getId() > 0){
    		card = cardService.getCard(card.getId());
    	}
    	return getResolution("card/form");
    }
    
    public Resolution saveCard(){
    	if(card.getCreatetime() == null){
    		card.setCreatetime(new Timestamp(new Date().getTime()));
    	}
    	cardService.saveCard(card);
    	return new RedirectResolution(getClass());
    }
    
    public Resolution delete(){
    	if(card != null){
    		cardService.delete(card.getId());
    	}
    	return new RedirectResolution(getClass());
    }

	public List<RfidCard> getCards() {
		return cards;
	}

	public RfidCard getCard() {
		return card;
	}

	public void setCardService(RfidCardService cardService) {
		this.cardService = cardService;
	}

	public void setCard(RfidCard card) {
		this.card = card;
	}
}
