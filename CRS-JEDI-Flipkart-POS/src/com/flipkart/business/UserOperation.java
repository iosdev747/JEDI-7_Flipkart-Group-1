package com.flipkart.business;

import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.*;

import org.apache.log4j.Logger;


public class UserOperation implements UserInterface {

    public UserOperation() {   // In future may be change to private

    }

    /**
     * Method to update password of a user
     *
     * @param userId
     * @param newPassword
     * @return boolean indicating if the password is updated successfully
     */
    @Override
    public boolean updatePassword(int userId, String newPassword) {
        Logger logger = Logger.getLogger(UserOperation.class);
        logger.debug("Updating Password for User with ID : " + Integer.toString(userId));
        UserDaoInterface userInterface = new UserDaoOperation();

        return userInterface.updatePassword(userId, newPassword);
    }

    /**
     * Method to verify User credentials
     *
     * @param userId
     * @param password
     * @return boolean indicating if user exists in the database
     */
    @Override
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException {
        Logger logger = Logger.getLogger(UserOperation.class);
        logger.debug("Verifying Credentials for User with ID : " + Integer.toString(userId));
        try {
            UserDaoInterface userInterface = new UserDaoOperation();

            return userInterface.verifyCredentials(userId, password);
        } finally {

        }
    }
}
