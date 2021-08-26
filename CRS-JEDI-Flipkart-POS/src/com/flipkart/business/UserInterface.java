package com.flipkart.business;

public interface UserInterface {

    public boolean updatePassword(int userId, String newPassword);

    public boolean verifyCredentials(int userId, String password);

}
