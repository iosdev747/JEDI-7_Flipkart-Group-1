package com.flipkart.bean;

public class Course {

    private String courseId;
    private String courseName;
    private int credits;
    private Professor professor;
    private double fee;
    private Student[] enrolledStudents = new Student[10];

    public void addStudent(Student student) {
    }

    public Course(String courseId, String courseName, int credits, Professor professor, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.professor = professor;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

}
