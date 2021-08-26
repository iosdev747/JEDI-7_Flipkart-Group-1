package com.flipkart.bean;

public class Professor extends User{
    private String department;
    private int professorEmpId;

    public Professor(int userID, String name, String password, String address, String department, int professorEmpId) {
        super(userID, name, password, address);
        this.department = department;
        this.professorEmpId = professorEmpId;
    }

    public Professor(String department, int professorEmpId) {
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

    public int getProfessorEmpId() {
        return professorEmpId;
    }

    public void setProfessorEmpId(int professorEmpId) {
        this.professorEmpId = professorEmpId;
    }
}
