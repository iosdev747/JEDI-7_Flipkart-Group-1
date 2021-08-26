package com.flipkart.business;

import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;


public class UserOperation implements UserInterface{

    public  UserOperation(){   // In future may be change to private

    }


    @Override
    public boolean updatePassword(int userId, String newPassword){
        UserDaoInterface userInterface = new UserDaoOperation();

        return userInterface.updatePassword(userId, newPassword);
    }

    @Override
    public boolean verifyCredentials(int userId, String password) {
        UserDaoInterface userInterface = new UserDaoOperation();

        return userInterface.verifyCredentials(userId, password);
    }
}
