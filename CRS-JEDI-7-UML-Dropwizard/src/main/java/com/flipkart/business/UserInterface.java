package com.flipkart.business;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {

    /**
     * update password
     *
     * @param userId
     * @param newPassword
     * @return
     */
    boolean updatePassword(int userId, String newPassword);

    /**
     * verify credentials
     *
     * @param userId
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

}
