package com.flipkart.bean;

public class Professor extends User{
    private String department;
    private String professorEmpId;

    public Professor(int userID, String name, String password, String address, String department, String professorEmpId) {
        super(userID, name, password, address);
        this.department = department;
        this.professorEmpId = professorEmpId;
    }
    

    public Professor() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfessorEmpId() {
        return professorEmpId;
    }

    public void setProfessorEmpId(String professorEmpId) {
        this.professorEmpId = professorEmpId;
    }
}
