package com.shrj.rfid.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:06
 */
@Entity
@Table(name="manage_channel")
public class ManageChannel {
    @Id @GeneratedValue
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
