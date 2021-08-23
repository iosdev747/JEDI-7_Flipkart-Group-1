package com.flipkart.service;

public interface UserInterface {

	boolean userSignup(String userID, String password);

	boolean forgetPassword(String userID, String newPassword);

	public boolean verifyCredentials(String userID, String password);

}
