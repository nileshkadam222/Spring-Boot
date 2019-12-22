 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
 
<form:form method="POST" commandName="user">
<form:errors/>
	<table>
		<tr>
			<td>User Name :</td>
			<td><form:input path="name" class="form-control"/>
			<form:errors path="name"/>
			
			</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:password path="password" class="form-control"/></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td><form:radiobutton path="gender" value="M" label="M"/> <form:radiobutton
				path="gender" value="F" label="F" /></td>
		</tr>
		<tr>
			<td>Country :</td>
			<td><form:select path="country" class="form-control"> 
				<form:option value="0" label="Select" />
				<form:options items="${countryList}" itemValue="countryName" itemLabel="countryName" />
			</form:select></td>
		</tr>
		<tr>
			<td>About you :</td>
			<td><form:textarea path="aboutYou" /></td>
		</tr>
		<tr>
			<td>Community :</td>
			<td><form:checkboxes path="communityList" items="${communityList}" itemValue="key" itemLabel="value" /></td>
		</tr>
		
		<tr>
			<td>Language :</td>
			<td><form:checkboxes path="languages" items="${lan}" itemValue="key" itemLabel="value" /></td>
		</tr>
		
		
		<tr>
			<td></td>
			<td><form:checkbox path="mailingList"
				label="Would you like to join our mailinglist?" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" class="btn btn-info"></td>
		</tr>
	</table>
</form:form>

</body>
</html>