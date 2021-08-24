package com.flipkart.bean;

public class Student extends User {

    private String studentId;
    private String Department;
    private int CurrentYear;

    public Student(int userId, String name, String password, String address, String studentId, String department,
                   int currentYear) {
        super(userId, name, password, address);
        this.studentId = studentId;
        Department = department;
        CurrentYear = currentYear;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
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