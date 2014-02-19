package com.shrj.rfid.admin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.shrj.rfid.admin.model.ManageChannel;
import com.shrj.rfid.admin.model.ManageNode;
import com.shrj.rfid.admin.model.ManageUser;
import com.shrj.rfid.admin.service.ManagerService;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:14
 */
@UrlBinding("/admin/dashboard.do")
public class DashboardAction extends BaseAdminAction {
    @SpringBean
    private ManagerService managerService;
    private List<ManageChannel> channels;
    private ManageUser manageUser;
    private Map<ManageChannel,List<ManageNode>> menus;

    @DefaultHandler
    public Resolution dashboard() {
        return getResolution("admin/dashboard");
    }

    public Resolution center() {
        return getResolution("admin/center");
    }

    public Resolution left() {
        manageUser=managerService.getManageUser(((ManageUser)request.getSession().getAttribute("manageUser")).getId());
        channels = managerService.getManageChannels();
        
        menus = new HashMap<ManageChannel, List<ManageNode>>();
        if(channels != null){
        	for(ManageChannel mc : channels){
        		menus.put(mc, getNodes(mc.getId(),manageUser.getNodes()));
        	}
        }
        return getResolution("admin/left");
    }

    private List<ManageNode> getNodes(long cid, String nodes) {
    	List<ManageNode> manageNodes = new ArrayList<ManageNode>();
		if (StringUtils.isBlank(nodes))
			return manageNodes;
		List<ManageNode> allNodes = managerService.getManageNodes();
		String[] mynodes = StringUtils.split(nodes, ",");
		for (ManageNode manageNode : allNodes) {
			if (ArrayUtils.contains(mynodes, manageNode.getId() + "")
					&& manageNode.getCid() == cid) {
				manageNodes.add(manageNode);
			}
		}
		return manageNodes;
	}
    
    public Resolution suc() {
        return getResolution("admin/suc");
    }

    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public List<ManageChannel> getChannels() {
        return channels;
    }

    public ManageUser getManageUser() {
        return manageUser;
    }

	public Map<ManageChannel, List<ManageNode>> getMenus() {
		return menus;
	}
}
