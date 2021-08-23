package com.flipkart.service;

public interface NotificationInterface {

	public void sendNotification(int userId, String message);

	public void receiveNotification(int userId, String message);

}
