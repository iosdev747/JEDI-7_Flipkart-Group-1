package com.flipkart.dao;

import com.flipkart.exception.*;

public interface UserDaoInterface {

    /**
     * verify credentials
     * @param userId
     * @param password
     * @return true/false
     * @throws UserNotFoundException
     */
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

    /**
     * update password
     * @param userId
     * @param newPassword
     * @return true/false
     */
    public boolean updatePassword(int userId, String newPassword);
}
