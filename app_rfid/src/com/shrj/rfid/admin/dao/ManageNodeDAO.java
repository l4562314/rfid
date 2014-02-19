package com.shrj.rfid.admin.dao;

import java.util.List;

import com.shrj.rfid.admin.model.ManageNode;
import com.shrj.rfid.dao.BaseDBDAO;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:11
 */
public class ManageNodeDAO extends BaseDBDAO<ManageNode>{
    public List<ManageNode> getManageNodes() {
        String hql="from ManageNode";
        return doQueryEntityList(hql);
    }

    public List<ManageNode> getManageNodes(long cid) {
        String hql="from ManageNode where cid="+cid;
        return doQueryEntityList(hql);
    }
}
