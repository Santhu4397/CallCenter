package com.example.CallCenter.Dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CallCenterDto {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Enumerated(EnumType.STRING)
	private CallStatus callStatus;
	private String name;
	private long phonenumber;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CallStatus getCallStatus() {
		return callStatus;
	}
	public void setCallStatus(CallStatus callStatus) {
		this.callStatus = callStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public CallCenterDto(int id, CallStatus callStatus, String name, long phonenumber) {
		super();
		this.id = id;
		this.callStatus = callStatus;
		this.name = name;
		this.phonenumber = phonenumber;
	}
	public CallCenterDto() {
		super();
	}
	

}
