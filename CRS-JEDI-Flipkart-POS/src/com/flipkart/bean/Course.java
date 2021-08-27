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

    /**
     * Method to get Course Id
     *
     * @return Course Id
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Method to set Course Id
     *
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Method to get the name of the Course
     *
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Method to set the name of the course
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Method to get the credit of a course
     *
     * @return credit
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Method to set the credit of a course
     *
     * @param credit
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * Method to get the Employee Id of Professor of a course
     *
     * @return professorEmpId
     */
    public String getProfessorEmpId() {
        return professorEmpId;
    }

    /**
     * Method to set the Employee Id of Professor of a course
     *
     * @param professorEmpId
     */
    public void setProfessorEmpId(String professorEmpId) {
        this.professorEmpId = professorEmpId;
    }

    /**
     * Method to get the fee amount of a course
     *
     * @return fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * Method to set the fee amount of a course
     *
     * @param fee
     */
    public void setFee(double fee) {
        this.fee = fee;
    }
}
