package com.teamsankya.employeewebapplication.util;

import java.io.FileReader;
import java.util.Properties;

import com.teamsankya.employeewebapplication.dao.EmployeeDAO;


public class EmployeeFactory {
	private EmployeeFactory() {

	}

	private static final EmployeeFactory EMPLOYEE_FACTORY = new EmployeeFactory();

	public static EmployeeFactory getInstence() {
		return EMPLOYEE_FACTORY;
	}

	public EmployeeDAO daoGenarater() {
		Properties properties = new Properties();
		String path = getClass().getResource("/config.properties").getPath();
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		EmployeeDAO dao = null;

		try {
			dao = (EmployeeDAO) Class.forName(properties.getProperty("dao_class")).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
