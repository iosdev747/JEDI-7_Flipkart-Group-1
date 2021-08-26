package com.flipkart.bean;

public class Admin extends User{
    private String empId;

    public Admin(int userID, String name, String password, String address, String empId) {
        super(userID, name, password, address);
        this.empId = empId;
    }

    public Admin() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
