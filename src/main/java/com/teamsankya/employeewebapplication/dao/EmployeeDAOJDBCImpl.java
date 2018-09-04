
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
import com.teamsankya.employeewebapplication.dto.EmployeeContactInfoBean;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
	private final String DBURL = "jdbc:mysql://localhost:3306/EmployeeDB?user=root&password=root";

	@Override
	public boolean createEmployee(EmployeeMasterBean bean) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Driver driver = new Driver();

			try (Connection con = DriverManager.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement("insert into Employee_info values(?,?,?,?)");
					PreparedStatement pstmt2 = con.prepareStatement("insert into Employee_address_info values(?,?,?,?)");
					PreparedStatement pstmt3 = con.prepareStatement("insert into Employee_contactinfo values(?,?,?)");
					PreparedStatement pstmt4 = con.prepareStatement("insert into Employee_careerinfo values(?,?,?,?)");
					PreparedStatement pstmt5 = con.prepareStatement("insert into Employee_experienceinfo values(?,?,?)")) {

				pstmt1.setInt(1, bean.getEmpbean().getId());
				pstmt1.setString(2, bean.getEmpbean().getFirstName());
				pstmt1.setString(3, bean.getEmpbean().getLastName());
				pstmt3.setDate(4, bean.getEmpbean().getDateOfBirth());

				pstmt2.setInt(1, bean.getEmpaddbean().getId());
				pstmt2.setString(2, bean.getEmpaddbean().getAddress());
				pstmt2.setString(3, bean.getEmpaddbean().getCity());
				pstmt2.setInt(4, bean.getEmpaddbean().getPincode());

				pstmt3.setInt(1, bean.getEmpconbean().getId());
				pstmt3.setLong(2, bean.getEmpconbean().getPnoneNumber());
				pstmt3.setString(3, bean.getEmpconbean().getEmailId());

				pstmt4.setInt(1, bean.getEmpcrbean().getId());
				pstmt4.setDate(2, bean.getEmpcrbean().getDateOfJoining());
				pstmt4.setString(3, bean.getEmpcrbean().getDesignation());
				pstmt4.setFloat(6, bean.getEmpcrbean().getCtc());
				
				pstmt5.setInt(1, bean.getEmpexpbean().getId());
				pstmt5.setFloat(2, bean.getEmpexpbean().getExperience());
				pstmt5.setString(3, bean.getEmpexpbean().getLastCompanyName());

				pstmt1.execute();
				pstmt2.execute();
				pstmt3.execute();
				pstmt4.execute();
				pstmt5.execute();
				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public EmployeeMasterBean getEmployee(int id) {
		EmployeeMasterBean empmastbean = new EmployeeMasterBean();
		EmployeeInfoBean empinfobean = new EmployeeInfoBean();
		EmployeeAddressInfoBean empaddbean = new EmployeeAddressInfoBean();
		EmployeeContactInfoBean empotrbean = new EmployeeContactInfoBean();
		EmployeeCareerInfoBean empcarbean = new EmployeeCareerInfoBean();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Creating JDBC objects");

			try (Connection con = DriverManager.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement("Select * from Employee_info where id =?");
					PreparedStatement pstmt2 = con.prepareStatement("select * from Employee_address_info where id =?");
					PreparedStatement pstmt3 = con.prepareStatement("select * from Employee_otherinfo where id =?");
					PreparedStatement pstmt4 = con.prepareStatement("select * from Employee_careerinfo where id =?");) {
				pstmt1.setInt(1, id);
				try (ResultSet rs1 = pstmt1.executeQuery()) {

					if (rs1.next()) {
						empinfobean.setId(rs1.getInt("id"));
						empinfobean.setFirstName(rs1.getString("firstName"));
						empinfobean.setFirstName(rs1.getString("middleName"));
						empinfobean.setFirstName(rs1.getString("lastName"));
						empinfobean.setDateOfBirth(rs1.getDate("dateOfBirth"));

					}
				}

				pstmt2.setInt(1, id);
				try (ResultSet rs2 = pstmt2.executeQuery()) {
					if (rs2.next()) {

						empaddbean.setId(rs2.getInt("id"));
						empaddbean.setAddress(rs2.getString("address"));
						empaddbean.setCity(rs2.getString("city"));
						empaddbean.setPincode(rs2.getInt("pincode"));

					}
				}

				pstmt3.setInt(1, id);
				try (ResultSet rs3 = pstmt3.executeQuery()) {
					if (rs3.next()) {

						empotrbean.setId(rs3.getInt("id"));
						empotrbean.setPnoneNumber(rs3.getInt("phoneno"));
						empotrbean.setPnoneNumber(rs3.getLong("phoneno"));
						empotrbean.setEmailId(rs3.getString("emailId"));

					}
				}

				pstmt4.setInt(1, id);
				try (ResultSet rs4 = pstmt4.executeQuery()) {
					if (rs4.next()) {

						empcarbean.setId(rs4.getInt("id"));
						empcarbean.setDesignation(rs4.getString("designation"));
						empcarbean.setDateOfJoining(rs4.getDate("dateOfJoining"));
						empcarbean.setCtc(rs4.getInt("ctc"));

					}
				}

				empmastbean.setEmpbean(empinfobean);
				empmastbean.setEmpaddbean(empaddbean);
				empmastbean.setEmpconbean(empotrbean);
				empmastbean.setEmpcrbean(empcarbean);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return empmastbean;

	}

	@Override
	public boolean updateStudent(EmployeeMasterBean bean) {

		try {

			Driver driver = new Driver();
			try (Connection con = DriverManager.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement(
							"update employee_info set first_name=?,last_name=?,date_of_birth=? where id=?");
					PreparedStatement pstmt2 = con.prepareStatement(
							"update employee_carrer_info set date_of_joining=?,designation=?,ctc=? where id=?");
					PreparedStatement pstmt3 = con.prepareStatement(
							"update employee_contact_info set phone_number=?,email_id=? where id=?");
					PreparedStatement pstmt4 = con.prepareStatement(
							"update employee_address_info set address=?,city=?,pincode=? where id=?");
					PreparedStatement pstmt5 = con.prepareStatement(
							"update employee_experience_info set experience=?,last_company_name=? where id=?");) {

				pstmt1.setInt(4, bean.getEmpbean().getId());
				pstmt1.setString(1, bean.getEmpbean().getFirstName());
				pstmt1.setString(2, bean.getEmpbean().getLastName());
				pstmt1.setDate(3, bean.getEmpbean().getDateOfBirth());
		
				pstmt2.setInt(4, bean.getEmpcrbean().getId());
				pstmt2.setDate(1, bean.getEmpcrbean().getDateOfJoining());
				pstmt2.setString(2,bean.getEmpcrbean().getDesignation());
				pstmt2.setFloat(3, bean.getEmpcrbean().getCtc());

				pstmt3.setInt(3, bean.getEmpconbean().getId());
				pstmt3.setLong(1, bean.getEmpconbean().getPnoneNumber());
				pstmt3.setString(2, bean.getEmpconbean().getEmailId());
				
				pstmt4.setInt(4, bean.getEmpaddbean().getId());
				pstmt4.setString(1, bean.getEmpaddbean().getAddress());
				pstmt4.setString(2, bean.getEmpaddbean().getCity());
				pstmt4.setInt(3, bean.getEmpaddbean().getPincode());
				
				pstmt5.setInt(3, bean.getEmpexpbean().getId());
				pstmt5.setFloat(1, bean.getEmpexpbean().getExperience());
				pstmt5.setString(2, bean.getEmpexpbean().getLastCompanyName());
				
				
				pstmt1.execute();
				pstmt2.execute();
				pstmt3.execute();
				pstmt4.execute();
				pstmt5.execute();

			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public boolean deleteStudent(EmployeeMasterBean bean) {
		try {

			// Driver driver = new Driver();
			try (Connection con = DriverManager.getConnection(DBURL);
					PreparedStatement pstmt1 = con.prepareStatement("delete from employee_info where id=?");
					PreparedStatement pstmt2 = con.prepareStatement("delete from employee_carrer_info where id=?");
					PreparedStatement pstmt3 = con.prepareStatement("delete from employee_contact_info where id=?");
					PreparedStatement pstmt4 = con.prepareStatement("delete from employee_address_info where id=?");) {
					PreparedStatement pstmt5 = con.prepareStatement("delete from employee_experience_info where id=?");
					
				pstmt1.setInt(1, bean.getEmpbean().getId());
				pstmt2.setInt(1, bean.getEmpcrbean().getId());
				pstmt3.setInt(1, bean.getEmpconbean().getId());
				pstmt4.setInt(1, bean.getEmpaddbean().getId());
				pstmt5.setInt(1, bean.getEmpexpbean().getId());

				pstmt1.execute();
				pstmt2.execute();
				pstmt3.execute();
				pstmt4.execute();
				pstmt5.execute();

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

}
