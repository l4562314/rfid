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
@UrlBinding("/monitor.do")
public class RfidMonitorAction extends BaseAdminAction {

    @DefaultHandler
    public Resolution exec() {
        return getResolution("monitor/show");
    }
}
