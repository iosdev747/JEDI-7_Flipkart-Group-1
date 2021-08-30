package com.flipkart.dao;

import com.flipkart.exception.*;

public interface UserDaoInterface {

    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

    public boolean updatePassword(int userId, String newPassword);
}
