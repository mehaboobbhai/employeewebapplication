package com.teamsankya.employeewebapplication.dto;

import java.util.Date;

public class EmployeeCareerInfoBean {
	private int id;
	private Date dateOfJoining;
	private String designation;
	private int experience;
	private String lastCompanyname;
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
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getLastCompanyname() {
		return lastCompanyname;
	}
	public void setLastCompanyname(String lastCompanyname) {
		this.lastCompanyname = lastCompanyname;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	

}
