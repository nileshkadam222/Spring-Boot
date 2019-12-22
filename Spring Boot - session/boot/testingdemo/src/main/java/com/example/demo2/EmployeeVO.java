package com.example.demo2;

public class EmployeeVO {
private String fname;
private int employeeById;
private String lname;
public int getEmployeeById() {
	return employeeById;
}
public void setEmployeeById(int employeeById) {
	this.employeeById = employeeById;
}
private String email;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public EmployeeVO(int employeeById, String fname, String lname, String email) {
	super();
	this.fname = fname;
	this.employeeById = employeeById;
	this.lname = lname;
	this.email = email;
}
public Integer employeeId;
public Integer getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(Integer employeeId) {
	this.employeeId = employeeId;
}
 


}
