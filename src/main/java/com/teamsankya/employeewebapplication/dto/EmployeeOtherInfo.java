package com.teamsankya.employeewebapplication.dto;

import java.util.Date;

public class EmployeeOtherInfo {
	private int id;
	private long phoneNumber;
	private String emailId;
	private Date dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
