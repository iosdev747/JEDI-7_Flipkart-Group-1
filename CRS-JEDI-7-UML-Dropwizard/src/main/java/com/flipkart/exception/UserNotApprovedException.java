package com.flipkart.exception;

public class UserNotApprovedException extends Exception {
    private final String userId;

    /**
     * Constructor
     *
     * @param userId
     */
    public UserNotApprovedException(String userId) {
        this.userId = userId;
    }

    /**
     * Getter for userId
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }
}
