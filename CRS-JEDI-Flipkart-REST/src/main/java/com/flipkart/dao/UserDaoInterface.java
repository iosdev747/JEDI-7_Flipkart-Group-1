package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDaoInterface {

    boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

    boolean updatePassword(int userId, String newPassword);
}
