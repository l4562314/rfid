package com.shrj.rfid.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rfid_card")
public class RfidCard implements Serializable {
	private static final long serialVersionUID = 5869090472055999088L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String code;
	private Timestamp createtime;
	private byte status;
	private byte type;
	private long apid;

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

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getApid() {
		return apid;
	}

	public void setApid(long apid) {
		this.apid = apid;
	}

}
