package com.shrj.rfid.admin.dao;

import java.util.List;

import com.shrj.rfid.admin.model.ManageUser;
import com.shrj.rfid.dao.BaseDBDAO;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:10
 */
public class ManageUserDAO extends BaseDBDAO<ManageUser>{
    public ManageUser getManageUser(String username, String password) {
        String hql="from ManageUser where username='"+username+"' and password='"+password+"' and status>=0";
        
        return doQueryEntityFirst(hql,0,username,password);
    }
    
    public ManageUser getManageUser(String username) {
        String hql="from ManageUser where username='"+username+"' and status>=0";
        return doQueryEntityFirst(hql,0,username);
    }

    public List<ManageUser> getManageUsers() {
        String hql="from ManageUser order by status desc";
        return doQueryEntityList(hql);
    }

    public List<ManageUser> getAllUsers(){
        String sql = "from ManageUser where status>=0";
        return doQueryEntityList(sql);
    }

    public List<ManageUser> getUsersById(int id){
        String sql = "from ManageUser where status>=0";
        if(id!=0){
            sql = "from ManageUser where id="+id;
        }
        return doQueryEntityList(sql);
    }
    public ManageUser getManageUser(int id){
        return this.get((long)id);
    }
}
