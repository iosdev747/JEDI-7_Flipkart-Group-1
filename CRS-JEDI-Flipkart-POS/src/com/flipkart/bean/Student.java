package com.flipkart.bean;

public class Student extends User {

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

    /**
     * Method to get the StudentId
     *
     * @return studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Method to set the StudentId
     *
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Method to get the Batch year for a student
     *
     * @return batch
     */
    public int getBatch() {
        return batch;
    }

    /**
     * Method to set the Batch year for a student
     *
     * @param batch
     */
    public void setBatch(int batch) {
        this.batch = batch;
    }

    /**
     * Method to get the Branch for a student
     *
     * @return branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Method to set the Branch for a student
     *
     * @param branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Method to get the Approval Status of a Student
     *
     * @return isApproved
     */
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Method to set the Approval Status of a Student
     *
     * @param approved
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
