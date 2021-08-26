package com.flipkart.bean;

public class Admin extends User{
    private int empId;

    public Admin(int userID, String name, String password, String address, int empId) {
        super(userID, name, password, address);
        this.empId = empId;
    }

    public Admin(int empId) {
        this.empId = empId;
    }

    public Admin() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
