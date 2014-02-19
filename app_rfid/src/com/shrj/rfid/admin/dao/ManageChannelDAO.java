package com.shrj.rfid.admin.dao;

import java.util.List;

import com.shrj.rfid.admin.model.ManageChannel;
import com.shrj.rfid.dao.BaseDBDAO;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:11
 */
public class ManageChannelDAO extends BaseDBDAO<ManageChannel> {

    public List<ManageChannel> getManageChannels() {
        String hql = "from ManageChannel";
        return doQueryEntityList(hql);
    }
}
