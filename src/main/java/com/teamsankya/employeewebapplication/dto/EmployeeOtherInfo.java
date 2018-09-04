package com.teamsankya.employeewebapplication.dto;

import java.util.Date;

public class EmployeeOtherInfo {
	private int id;
	private int pnoneNumber;
	private String emailId;
	private Date dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPnoneNumber() {
		return pnoneNumber;
	}
	public void setPnoneNumber(int pnoneNumber) {
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
