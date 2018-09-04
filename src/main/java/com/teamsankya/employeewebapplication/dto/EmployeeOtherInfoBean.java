package com.teamsankya.employeewebapplication.dto;

import java.util.Date;

public class EmployeeOtherInfoBean {
	private int id;
	private long pnoneNumber;
	private String emailId;
	private Date dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPnoneNumber() {
		return pnoneNumber;
	}
	public void setPnoneNumber(long pnoneNumber) {
		this.pnoneNumber = pnoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
