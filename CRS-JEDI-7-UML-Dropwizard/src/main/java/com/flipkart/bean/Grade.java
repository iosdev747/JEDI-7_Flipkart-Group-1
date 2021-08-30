package com.flipkart.bean;

public class Grade {

    private String studentId;
    private String courseId;
    private double grade;

    public Grade(String studentId, String courseId, double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    /**
     * Method to get the StudentId of a Grade
     *
     * @return studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Method to set the StudentId of a Grade
     *
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Method to get the CourseId of a Grade
     *
     * @return courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Method to set the CourseId of a Grade
     *
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Method to get the grade
     *
     * @return grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Method to set the grade
     *
     * @return grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
