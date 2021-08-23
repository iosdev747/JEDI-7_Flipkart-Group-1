
package com.flipkart.bean;
public class Professor extends User{
	private String department ;
	private int empId ;
	public Professor(String userId, String name, String password, Gender gender, String address, String department,
			int empId) {
		super(userId, name, password, gender, address);
		this.department = department;
		this.empId = empId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	
}
