package com.teamsankya.employeewebapplication.dao;


import com.teamsankya.employeewebapplication.dto.EmployeeMasterBean;

public interface EmployeeDAO {
	public void createStudent(EmployeeMasterBean bean);
	public EmployeeMasterBean getEmployee(int id);


}