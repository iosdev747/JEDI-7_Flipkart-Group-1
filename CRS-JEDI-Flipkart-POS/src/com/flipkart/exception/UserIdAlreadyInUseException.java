package com.flipkart.exception;

public class UserIdAlreadyInUseException extends Exception{
    private String userId;


    /**
     * Constructor
     */
    public UserIdAlreadyInUseException(String userId) {
        this.userId = userId;
    }

    /**
     * Method to get usere ID
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Method to set professor ID
     * @param userId
     */
    public void setProfessorId(String userId) {
        this.userId = userId;
    }

    /**
     * Method to throw exception message
     * @return
     */
    @Override
    public String getMessage() {
        return "userId: " + userId + " is already in use.";
    }
}
