package com.flipkart.business;

import com.flipkart.exception.*;

public interface UserInterface {

    /**
     * update password
     * @param userId
     * @param newPassword
     * @return
     */
    public boolean updatePassword(int userId, String newPassword);

    /**
     * verify credentials
     * @param userId
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

}
