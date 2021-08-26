package com.flipkart.bean;

public class EnrolledStudent {
    private String courseId;
    private int studentId;

    public EnrolledStudent(String courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
