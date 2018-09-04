
package com.teamsankya.employeewebapplication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;
import com.teamsankya.employeewebapplication.dto.EmployeeAddressInfoBean;
import com.teamsankya.employeewebapplication.dto.EmployeeCareerInfoBean;
import com.teamsankya.employeewebapplication.dto.EmployeeInfoBean;
import com.teamsankya.employeewebapplication.dto.EmployeeMasterBean;
import com.teamsankya.employeewebapplication.dto.EmployeeOtherInfoBean;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{
	private final String DBURL="jdbc:mysql://localhost:3306/EmployeeDB?user=root&password=root";

	@Override
	public void createStudent(EmployeeMasterBean bean) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Driver driver = new Driver();

			try (Connection con = DriverManager.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement("insert into Employee_info values(?,?,?,?)");
					PreparedStatement pstmt2 = con.prepareStatement("insert into Employee_address_info values(?,?,?,?,?,?)");
					PreparedStatement pstmt3 = con.prepareStatement("insert into Employee_otherinfo values(?,?,?,?)");
					PreparedStatement pstmt4 = con.prepareStatement("insert into Employee_cereerinfo values(?,?,?,?,?,?)")) {

				pstmt1.setInt(1, bean.getEmpbean().getId());
				pstmt1.setString(2, bean.getEmpbean().getFirstName());
				pstmt1.setString(3, bean.getEmpbean().getMiddleName());
				pstmt1.setString(3, bean.getEmpbean().getLastName());
				
				pstmt2.setInt(1, bean.getEmpaddbean().getId());
				pstmt2.setString(2, bean.getEmpaddbean().getAddress_type());
				pstmt2.setString(3, bean.getEmpaddbean().getAddress1());
				pstmt2.setString(4, bean.getEmpaddbean().getAddress2());
				pstmt2.setString(5, bean.getEmpaddbean().getCity());
				pstmt2.setInt(6, bean.getEmpaddbean().getPincode());
				
				pstmt3.setInt(1, bean.getEmpotrbean().getId());
				pstmt3.setInt(2, bean.getEmpotrbean().getPnoneNumber());
				pstmt3.setString(3, bean.getEmpotrbean().getEmailId());
				pstmt3.setDate(4, (Date) bean.getEmpotrbean().getDateOfBirth());
				
				
				pstmt4.setInt(1, bean.getEmpcrbean().getId());
				pstmt4.setDate(2, (Date) bean.getEmpcrbean().getDateOfJoining());
				pstmt4.setString(3, bean.getEmpcrbean().getDesignation());
				pstmt4.setDouble(4, bean.getEmpcrbean().getExperience());
				pstmt4.setString(5, bean.getEmpcrbean().getLastCompanyName());
				pstmt4.setInt(6, bean.getEmpcrbean().getCtc());

				pstmt1.execute();
				pstmt2.execute();
				pstmt3.execute();
				pstmt4.execute();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	
	@Override
	public EmployeeMasterBean getEmployee(int id) {
		EmployeeMasterBean empmastbean = new EmployeeMasterBean();
		EmployeeInfoBean empinfobean = new EmployeeInfoBean();
		EmployeeAddressInfoBean empaddbean = new EmployeeAddressInfoBean();
		EmployeeOtherInfoBean empotrbean = new EmployeeOtherInfoBean();
		EmployeeCareerInfoBean empcarbean = new EmployeeCareerInfoBean();
		

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Creating JDBC objects");

			try (Connection con = DriverManager.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement("Select * from Employee_info where id =?");
					PreparedStatement pstmt2 = con.prepareStatement("select * from Employee_address_info where id =?");
					PreparedStatement pstmt3 = con.prepareStatement("select * from Employee_otherinfo where id =?");
					PreparedStatement pstmt4 = con.prepareStatement("select * from Employee_cereerinfo where id =?");) {
				pstmt1.setInt(1, id);
				try (ResultSet rs1 = pstmt1.executeQuery()) {

					if (rs1.next()) {
						empinfobean.setId(rs1.getInt("id"));
						empinfobean.setFirstName(rs1.getString("firstName"));
						empinfobean.setFirstName(rs1.getString("middleName"));
						empinfobean.setFirstName(rs1.getString("lastName"));

					}
				}
				
				pstmt2.setInt(1, id);
               	try (ResultSet rs2 = pstmt2.executeQuery()) {
					if (rs2.next()) {
						
						empaddbean.setId(rs2.getInt("id"));
						empaddbean.setAddress_type(rs2.getString("addressType"));
						empaddbean.setAddress1(rs2.getString("address1"));
						empaddbean.setAddress2(rs2.getString("address2"));
						empaddbean.setCity(rs2.getString("city"));
						empaddbean.setPincode(rs2.getInt("pincode"));

					}
				}
				
               	pstmt3.setInt(1, id);
				try (ResultSet rs3 = pstmt3.executeQuery()) {	
					if (rs3.next()) {

						empotrbean.setId(rs3.getInt("id"));
						empotrbean.setPnoneNumber(rs3.getInt("phoneno"));
						empotrbean.setEmailId(rs3.getString("emailId"));
						empotrbean.setDateOfBirth(rs3.getDate("dateOfBirth"));

					}
				}
				
				pstmt4.setInt(1, id);
				try (ResultSet rs4 = pstmt4.executeQuery()) {	
					if (rs4.next()) {

						empcarbean.setId(rs4.getInt("id"));
						empcarbean.setExperience(rs4.getDouble("exprience"));
						empcarbean.setDesignation(rs4.getString("designation"));
						empcarbean.setLastCompanyName(rs4.getString("lastCompanyName"));
						empcarbean.setDateOfJoining(rs4.getDate("dateOfJoining"));
						empcarbean.setCtc(rs4.getInt("ctc"));

					}
				}
				
				empmastbean.setEmpbean(empinfobean);
				empmastbean.setEmpaddbean(empaddbean);
				empmastbean.setEmpotrbean(empotrbean);
				empmastbean.setEmpcrbean(empcarbean); 

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return empmastbean;

	}
	
	
	@Override
	public void updateStudent(EmployeeMasterBean bean) {

		try {

			Driver driver = new Driver();
			try (Connection con = DriverManager.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement("update employee_info set first_name=?,last_name=?,middle_name=? where id=?");
					PreparedStatement pstmt2 = con.prepareStatement("update employee_addressinfo set address_type=?,address1=?,address2=?,city=?,pincode=? where id=?");
					PreparedStatement pstmt3 = con.prepareStatement("update employee_otherinfo set phone_number=?,email_id=?,date_of_birth=? where id=?");
					PreparedStatement pstmt4 = con.prepareStatement("update employee_carrerinfo set date_of_joining=?,designation=?,experience=?,last_company_name=?,ctc=? where id=?");) {

				pstmt1.setInt(4, bean.getEmpbean().getId());
				pstmt1.setString(1, bean.getEmpbean().getFirstName());
				pstmt1.setString(2, bean.getEmpbean().getLastName());
				pstmt1.setString(3, bean.getEmpbean().getMiddleName());

				pstmt2.setInt(6, bean.getEmpaddbean().getId());
				pstmt2.setString(1, bean.getEmpaddbean().getAddress_type());
				pstmt2.setString(2, bean.getEmpaddbean().getAddress1());
				pstmt2.setString(3, bean.getEmpaddbean().getAddress2());
				pstmt2.setString(4, bean.getEmpaddbean().getCity());
				pstmt2.setInt(5, bean.getEmpaddbean().getPincode());

				pstmt3.setInt(4, bean.getEmpotrbean().getId());
				pstmt3.setString(1, bean.getEmpotrbean().getEmailId());
				pstmt3.setInt(2, bean.getEmpotrbean().getPnoneNumber());
				pstmt3.setDate(3, (Date) bean.getEmpotrbean().getDateOfBirth());
				
				pstmt4.setInt(6, bean.getEmpcrbean().getId());
				pstmt4.setString(2, bean.getEmpcrbean().getDesignation());
				pstmt4.setString(4, bean.getEmpcrbean().getLastCompanyName());
				pstmt4.setDate(1, (Date) bean.getEmpcrbean().getDateOfJoining());
				pstmt4.setInt(5, bean.getEmpcrbean().getCtc());
				pstmt4.setDouble(3, bean.getEmpcrbean().getExperience());

				pstmt1.execute();
				pstmt2.execute();
				pstmt3.execute();
				pstmt4.execute();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(EmployeeMasterBean bean) {
		try {

			Driver driver = new Driver();
			try (Connection con = DriverManager
					.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement("delete from Employee_info where regno=?");
					PreparedStatement pstmt2 = con.prepareStatement("delete from Employee_address_info where regno=?");
					PreparedStatement pstmt3 = con.prepareStatement("delete from Employee_otherinfo where regno=?");
					PreparedStatement pstmt4 = con.prepareStatement("delete from Employee_cereerinfo where regno=?");) {

				pstmt1.setInt(1, bean.getEmpbean().getId());

				pstmt2.setInt(1, bean.getEmpaddbean().getId());

				pstmt3.setInt(1, bean.getEmpotrbean().getId());
				
				pstmt4.setInt(1, bean.getEmpcrbean().getId());

				pstmt1.execute();
				pstmt2.execute();
				pstmt3.execute();
				pstmt4.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}


