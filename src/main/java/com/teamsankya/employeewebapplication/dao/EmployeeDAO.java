package com.teamsankya.employeewebapplication.dao;


import com.teamsankya.employeewebapplication.dto.EmployeeMasterBean;

public interface EmployeeDAO {
	public boolean createEmployee(EmployeeMasterBean bean);
	public EmployeeMasterBean getEmployee(int id);

	public boolean deleteStudent(EmployeeMasterBean bean);
	public boolean updateStudent(EmployeeMasterBean bean);

}
