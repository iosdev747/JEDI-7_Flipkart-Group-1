package com.flipkart.business;

import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;


public class UserOperation implements UserInterface {

    /**
     * Constructor
     */
    public UserOperation() {   // In future may be change to private

    }

    /**
     * update password
     *
     * @param userId
     * @param newPassword
     * @return
     */
    @Override
    public boolean updatePassword(int userId, String newPassword) {
        Logger logger = Logger.getLogger(UserOperation.class);
        logger.debug("Updating Password for User with ID : " + userId);
        UserDaoInterface userInterface = new UserDaoOperation();

        return userInterface.updatePassword(userId, newPassword);
    }

    /**
     * verify credentials
     *
     * @param userId
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException {
        Logger logger = Logger.getLogger(UserOperation.class);
        logger.debug("Verifying Credentials for User with ID : " + userId);
        try {
            UserDaoInterface userInterface = new UserDaoOperation();

            return userInterface.verifyCredentials(userId, password);
        } finally {

        }
    }
}
