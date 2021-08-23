
package com.flipkart.bean;


public class Admin extends User{
	private int empId ;

	public Admin(String userId, String name, String password, Gender gender, String address, int empId) {
		super(userId, name, password, gender, address);
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
}
