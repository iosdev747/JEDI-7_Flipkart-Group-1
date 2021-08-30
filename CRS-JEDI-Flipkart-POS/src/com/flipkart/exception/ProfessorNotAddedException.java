package com.flipkart.exception;

public class ProfessorNotAddedException extends Exception {
    private final String professorId;

    /**
     * Constructor
     */
    public ProfessorNotAddedException(String professorId) {
        this.professorId = professorId;
    }

    /**
     * Getter function for professorId
     *
     * @return
     */
    public String getUserId() {
        return this.professorId;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "professorId: " + professorId + " not added!";
    }
}
