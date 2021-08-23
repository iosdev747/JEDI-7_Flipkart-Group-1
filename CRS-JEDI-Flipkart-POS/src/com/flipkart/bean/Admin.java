
package com.flipkart.bean;

public class Admin extends User {
	private int empId;

	public Admin(String userId, String name, String password, String address, int empId) {
		super(userId, name, password, address);
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
