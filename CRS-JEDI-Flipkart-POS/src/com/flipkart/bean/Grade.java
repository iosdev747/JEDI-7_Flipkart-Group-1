package com.flipkart.bean;

public class Grade {

    private String courseId;
    private double grade;
    private String studentId;

    public Grade(String courseId, double grade, String studentId) {
        this.courseId = courseId;
        this.grade = grade;
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
