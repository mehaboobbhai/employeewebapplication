package com.teamsankya.employeewebapplication.dto;

import java.util.Date;

public class EmployeeCareerInfoBean {
	private int id;
	private Date dateOfJoining;
	private String designation;
	private double experience;
	private String lastCompanyName;
	private int ctc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public String getLastCompanyName() {
		return lastCompanyName;
	}
	public void setLastCompanyName(String lastCompanyName) {
		this.lastCompanyName = lastCompanyName;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	

}
