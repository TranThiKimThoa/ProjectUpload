package com.paracel.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="RfidCard")
public class RfidCard implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="RfidCard_id")
    private String rfidCardId;  
	@Column(name="RfidReader_id")
    private String rfidReaderId;
	@Column(name="Status")	
	private String status;
	public RfidCard() {
		super();
	}
	public String getRfidCardId() {
		return rfidCardId;
	}
	public void setRfidCardId(String rfidCardId) {
		this.rfidCardId = rfidCardId;
	}
	public String getRfidReaderId() {
		return rfidReaderId;
	}
	public void setRfidReaderId(String rfidReaderId) {
		this.rfidReaderId = rfidReaderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
} 