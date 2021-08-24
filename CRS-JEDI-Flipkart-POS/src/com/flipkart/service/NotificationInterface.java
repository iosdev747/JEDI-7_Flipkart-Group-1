package com.flipkart.service;

public interface NotificationInterface {

    void sendNotification(int userId, String message);

    void receiveNotification(int userId, String message);

}
