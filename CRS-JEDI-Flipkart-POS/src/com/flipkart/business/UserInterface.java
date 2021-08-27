package com.flipkart.business;

import com.flipkart.exception.*;

public interface UserInterface {
    /**
     * Method to update password of a user
     *
     * @param userId
     * @param newPassword
     * @return boolean indicating if the password is updated successfully
     */
    public boolean updatePassword(int userId, String newPassword);

    /**
     * Method to verify User credentials
     *
     * @param userId
     * @param password
     * @return boolean indicating if user exists in the database
     */
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

}
