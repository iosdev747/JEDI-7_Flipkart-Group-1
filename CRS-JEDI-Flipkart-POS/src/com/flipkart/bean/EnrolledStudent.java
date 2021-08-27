package com.flipkart.bean;

public class EnrolledStudent {
    private String courseId;
    private String studentId;

    public EnrolledStudent(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    /**
     * Method to get the CourseId of an Enrolled Student
     *
     * @return courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Method to set the CourseId of an Enrolled Student
     *
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Method to get the StudentId of an Enrolled Student
     *
     * @return studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Method to set the StudentId of an Enrolled Student
     *
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
