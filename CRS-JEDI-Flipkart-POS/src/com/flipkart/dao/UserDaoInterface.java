package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {

    /**
     * verify credentials
     *
     * @param userId
     * @param password
     * @return true/false
     * @throws UserNotFoundException
     */
    boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

    /**
     * update password
     *
     * @param userId
     * @param newPassword
     * @return true/false
     */
    boolean updatePassword(int userId, String newPassword);
}
