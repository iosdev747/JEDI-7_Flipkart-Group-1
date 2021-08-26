package com.flipkart.bean;

public class Professor extends User {
    private String department;
    private String professorEmpId;

    public Professor(int userID, String name, String password, String address, String department, String professorEmpId) {
        super(userID, name, password, address);
        this.department = department;
        this.professorEmpId = professorEmpId;
    }


    public Professor() {
    }

    /**
     * Method to get the Department of a Professor
     *
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Method to set the Department of a Professor
     *
     * @param department
     */


    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Method to get the Professor Employee Id
     *
     * @return professorEmpId
     */
    public String getProfessorEmpId() {
        return professorEmpId;
    }

    /**
     * Method to set the Professor Employee Id
     *
     * @param professorEmpId
     */
    public void setProfessorEmpId(String professorEmpId) {
        this.professorEmpId = professorEmpId;
    }
}
