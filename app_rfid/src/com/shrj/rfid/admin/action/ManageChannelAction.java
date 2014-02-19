package com.shrj.rfid.admin.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import com.shrj.rfid.action.BaseAction;
import com.shrj.rfid.admin.model.ManageChannel;
import com.shrj.rfid.admin.service.ManagerService;

/**
 * User: chjp
 * Date: 11-10-20
 * Time: 上午11:00
 */
@UrlBinding("/admin/manage_channel.do")
public class ManageChannelAction extends BaseAction {
    @SpringBean
    private ManagerService managerService;
    private List<ManageChannel> channels;
    private ManageChannel channel;
    private long id;

    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @DefaultHandler
    public Resolution list() {
        channels = managerService.getManageChannels();
        return getResolution("admin/manageChannelList");
    }

    public Resolution form() {
        if (id > 0) {
            channel = managerService.getManageChannel(id);
        }
        return getResolution("admin/manageChannelForm");
    }

    public Resolution submit() {
        managerService.saveManageChannel(channel);
        return new RedirectResolution(getClass());
    }

    public void setChannel(ManageChannel channel) {
        this.channel = channel;
    }

    public List<ManageChannel> getChannels() {
        return channels;
    }

    public ManageChannel getChannel() {
        return channel;
    }

    public void setId(long id) {
        this.id = id;
    }
}
