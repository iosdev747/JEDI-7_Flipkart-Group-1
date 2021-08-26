package com.flipkart.dao;
import java.util.ArrayList;

public interface NotificationDaoInterface {
    /**
     * Send Notification - Creates entry for notification in DB using SQL
     * @param userID: User ID for whom the notification is
     * @param msg: Message to be sent
     * @return notification ID
     */
    public String sendNotification(int userID, String msg);
    /**
     * Read Notification
     * @param userID: userID to view all notifications for
     * @return notification message
     */
    public ArrayList<String> readNotification(int userID);
}