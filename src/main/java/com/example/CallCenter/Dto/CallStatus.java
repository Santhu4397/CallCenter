 package com.example.CallCenter.Dto;

import com.fasterxml.jackson.annotation.JsonValue;


public enum CallStatus {
	NOTRECIVING(0,"not reciving"),
	NOTINTRESTED (1,"not intrested"),
	NOTCONNECTING(2,"not connecting"),
	CALLLATER(3,"call later"),
	INTRESTED(4,"intrested");
	private int value=0; 
	private String name=null;
	CallStatus(){
		
	}
	CallStatus(Integer value ,String name) {
		this.value=value;
		this.name=name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@JsonValue
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	  public String toString() {
		  final StringBuilder sb=new StringBuilder();
		  sb.append("Status");
		  sb.append("{value=").append(value);
		  sb.append(", text='").append(name).append('\'');
		  sb.append('}');
		  return sb.toString();
		  
	  }
	

	

}

