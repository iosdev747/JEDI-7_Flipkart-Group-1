/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * 
 * @author JEDI-03
 * Student Class
 * 
 */
public class Student extends User {
	private int studentId;
	private String Department ;
	private int CurrentYear ;
	public Student(String userId, String name, String password, src.com.flipkart.bean.Gender gender, String address,
			int studentId, String department, int currentYear) {
		super(userId, name, password, gender, address);
		this.studentId = studentId;
		Department = department;
		CurrentYear = currentYear;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public int getCurrentYear() {
		return CurrentYear;
	}
	public void setCurrentYear(int currentYear) {
		CurrentYear = currentYear;
	}
	
	
	
	
}