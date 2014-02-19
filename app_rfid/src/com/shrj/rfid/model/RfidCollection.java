package com.shrj.rfid.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rfid_collection")
public class RfidCollection implements Serializable {
	private static final long serialVersionUID = -5337817761316237969L;
	@Id
	@GeneratedValue
	private long id;
	private Timestamp createtime;
	private byte status;
	private long cardid;
	private long apid;
	private long workerid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getCardid() {
		return cardid;
	}

	public void setCardid(long cardid) {
		this.cardid = cardid;
	}

	public long getApid() {
		return apid;
	}

	public void setApid(long apid) {
		this.apid = apid;
	}

	public long getWorkerid() {
		return workerid;
	}

	public void setWorkerid(long workerid) {
		this.workerid = workerid;
	}

}
