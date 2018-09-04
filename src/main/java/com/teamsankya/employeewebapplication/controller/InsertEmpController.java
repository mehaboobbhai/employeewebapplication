package com.teamsankya.employeewebapplication.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.employeewebapplication.dao.EmployeeDAO;
import com.teamsankya.employeewebapplication.dto.EmployeeAddressInfoBean;
import com.teamsankya.employeewebapplication.dto.EmployeeCareerInfoBean;
import com.teamsankya.employeewebapplication.dto.EmployeeInfoBean;
import com.teamsankya.employeewebapplication.dto.EmployeeMasterBean;
import com.teamsankya.employeewebapplication.dto.EmployeeOtherInfoBean;
import com.teamsankya.employeewebapplication.util.EmployeeFactory;

public class InsertEmpController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeInfoBean eInfoBean = new EmployeeInfoBean();
		eInfoBean.setFirstName(req.getParameter("e_fname"));
		eInfoBean.setMiddleName(req.getParameter("e_mname"));
		eInfoBean.setLastName(req.getParameter("e_last"));

		EmployeeAddressInfoBean eAddrBean = new EmployeeAddressInfoBean();
		eAddrBean.setAddress_type(req.getParameter("e_addrType"));
		eAddrBean.setAddress1(req.getParameter("e_address1"));
		eAddrBean.setAddress2(req.getParameter("e_address2"));
		eAddrBean.setCity(req.getParameter("e_city"));
		eAddrBean.setPincode(Integer.parseInt(req.getParameter("e_pincode")));

		EmployeeCareerInfoBean eCareBean = new EmployeeCareerInfoBean();
		eCareBean.setLastCompanyName(req.getParameter("e_company"));
		/*eCareBean.setDateOfJoining(Integer.parseInt(req.getParameter("e_doj")));*/
		eCareBean.setDesignation(req.getParameter("e_designation"));
		eCareBean.setCtc(Integer.parseInt(req.getParameter("e_ctc")));
		eCareBean.setExperience(Double.parseDouble(req.getParameter("e_company")));

		EmployeeOtherInfoBean eOtherBean = new EmployeeOtherInfoBean();
		/*eOtherBean.setDateOfBirth((req.getParameter("e_dob")));*/
		eOtherBean.setPnoneNumber(Long.parseLong(req.getParameter("e_phone")));
		eOtherBean.setEmailId(req.getParameter("e_email"));

		EmployeeMasterBean emasterBean = new EmployeeMasterBean();
		emasterBean.setEmpbean(eInfoBean);
		emasterBean.setEmpaddbean(eAddrBean);
		emasterBean.setEmpcrbean(eCareBean);
		emasterBean.setEmpotrbean(eOtherBean);

		EmployeeDAO dao = EmployeeFactory.getInstence().daoGenarater();
		dao.createEmployee(emasterBean);
		req.getRequestDispatcher("/success.jsp").forward(req, resp);
	}

}
