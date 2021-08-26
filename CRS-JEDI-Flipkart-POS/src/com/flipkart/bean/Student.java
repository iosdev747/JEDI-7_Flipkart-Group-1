package com.flipkart.bean;

public class Student extends User{

    private String studentId;
    private int batch;
    private String branch;
    private boolean isApproved;

    public Student(int userID, String name, String password, String address, String studentId, int batch, String branch, boolean isApproved) {
        super(userID, name, password, address);
        this.studentId = studentId;
        this.batch = batch;
        this.branch = branch;
        this.isApproved = isApproved;
    }
    

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
