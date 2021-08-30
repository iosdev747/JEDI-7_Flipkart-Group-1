package com.flipkart.bean;

public class Admin extends User {
    private String empId;

    public Admin(int userID, String name, String password, String address, String empId) {
        super(userID, name, password, address);
        this.empId = empId;
    }

    public Admin() {
    }

    /**
     * Method to get Employee Id
     *
     * @return Employee Id
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Method to set Employee Id
     *
     * @param empId Id
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
