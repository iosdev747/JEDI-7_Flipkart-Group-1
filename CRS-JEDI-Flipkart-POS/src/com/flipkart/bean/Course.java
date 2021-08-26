package com.flipkart.bean;

public class Course {

    private String courseId;
    private String courseName;
    private int credit;
    private String professorEmpId;
    private double fee;

    public Course() {
    }

    public Course(String courseId, String courseName, int credit, String professorEmpId, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.professorEmpId = professorEmpId;
        this.fee = fee;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getProfessorEmpId() {
        return professorEmpId;
    }

    public void setProfessorEmpId(String professorEmpId) {
        this.professorEmpId = professorEmpId;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
