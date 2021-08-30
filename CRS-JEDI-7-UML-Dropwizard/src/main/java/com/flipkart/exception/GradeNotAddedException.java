package com.flipkart.exception;

public class GradeNotAddedException extends Exception {

    private final String studentId;

    /**
     * Constructor
     */
    public GradeNotAddedException(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Get student Id
     *
     * @return
     */
    public String getStudentId() {
        return studentId;
    }

    @Override
    public String getMessage() {
        return "StudentId: " + studentId + " Grades Not Added!";
    }
}