package com.flipkart.dao;

public interface UserDaoInterface {

    public boolean verifyCredentials(int userId, String password);

    public boolean updatePassword(int userId, String newPassword);
}
