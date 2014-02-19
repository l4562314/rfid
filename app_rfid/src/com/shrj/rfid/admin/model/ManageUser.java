package com.shrj.rfid.admin.model;

import javax.persistence.*;

/**
 * User: chjp
 * Date: 11-10-11
 * Time: 下午4:05
 */
@Entity
@Table(name="manage_user")
public class ManageUser {
    @Id @GeneratedValue
    private long id;
    private String username;
    private String password;
    @Lob
    private String nodes;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
