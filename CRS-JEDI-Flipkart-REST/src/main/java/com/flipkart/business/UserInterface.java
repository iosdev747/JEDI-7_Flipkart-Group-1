package com.flipkart.business;

import com.flipkart.exception.*;

public interface UserInterface {

    public boolean updatePassword(int userId, String newPassword);

    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

}
