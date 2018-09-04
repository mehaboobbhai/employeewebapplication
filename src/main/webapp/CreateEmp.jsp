<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
	<script type="text/javascript">
function selectFun(){
    var emp = document.getElementById("emp").value;
    console.log(" value is "+emp);
    if(emp=="Fresher"){
        document.getElementById("hideEmp").style.visibility="hidden"
    }
    else{
        document.getElementById("hideEmp").style.visibility="visible"
    }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./fs" method="post">


		<table width="100">
			<tr>
				<td>
					<fieldset>
						<legend>
							<B>Employee Related Info ...</B>
						</legend>
						<table>
						
						
							<tr>
								<td>Emp_Fname</td>
								<td><input type="text" name="e_fname"
									placeholder="First Name" required="required" /></td>
							</tr>
							<tr>
								<td>Emp_Lname</td>
								<td><input type="text" name="e_lname"
									placeholder="Last Name" required="required" /></td>
						
				
							<tr>
								<td>Emp_EmailId</td>
								<td><input type="email" name=e_email
									placeholder="Email_id" required="required" /></td>
							</tr>
							<tr>
								<td>Emp_Phone</td>
								<td><input type="number" name="e_phone"
									placeholder="Emp_Phone" required="required" /></td>
						
						
							<tr>
								<td>Emp_Address</td>
								<td><input type="text" name="e_address"
									placeholder="Address" required="required" /></td>
							</tr>
							<tr>
								<td>Date of Join</td>
								<td><input type="number" name="e_aoj"
									placeholder="DOJ" required="required" /></td>
							</tr>
							<tr>
								<td>Date of Birth</td>
								<td><input type="number" name="e_dob"
									placeholder="DOB" required="required" /></td>
							</tr>
							<tr>
								<td>Designation</td>
								<td><input type="text" name="Designation"
									placeholder="Designation" required="required" /></td>
							</tr>
						
							
							<tr>
							
								<td>Emp_City</td>
								<td><input type="text" name="e_location"
									placeholder="City" required="required" /></td>
							</tr>
							<tr>
								<td>Emp_Pincode</td>
								<td><input type="number" name="e_pincode"
									placeholder="Pincode" required="required" /></td>
									
							</tr>
							<tr>
								<td>Fresher/Exp </td>
								<td><select id="emp" onchange="selectFun()">
           
							<option  value="Employess">Expirence</option>
							<option  value="Fresher">Freshers</option></td>
						</select>
						</table>	
						<table  id="hideEmp">
						<tr>
								<td>Last Company</td>
								<td><input type="text" name="Company"
									placeholder="Cmp_Name" required="required" /></td>
							</tr>
							
								<tr>
								<td>CTC</td>
								<td><input type="text" name="CTC"
									placeholder="CTC" required="required" /></td>
						</tr>
							</table>
							<input type="submit" value="submit"/>
							<input type="reset" value="reset"/>
					</fieldset>
</body>
</html>