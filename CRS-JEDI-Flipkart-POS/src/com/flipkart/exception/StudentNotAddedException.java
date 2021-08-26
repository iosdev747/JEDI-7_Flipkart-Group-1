package com.flipkart.exception;

public class StudentNotAddedException extends Exception{
    private String studentId;

    public StudentNotAddedException(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Getter function for professorId
     * @return
     */
    public String getUserId() {
        return this.studentId;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "studentId: " + studentId + " not added!";
    }
}
