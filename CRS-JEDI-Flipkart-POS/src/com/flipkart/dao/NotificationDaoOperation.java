package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NotificationDaoOperation implements NotificationDaoInterface{
    public int sendNotification(int userId, String msg) {
        statement = null;
        String sql = "INSERT INTO Notifications(userID, msg, isSeen) values (?, ?, ?)"
        statement = connection.prepareStatement(sql);

        statement.setString(1, userId);
        statement.setString(2, msg);
        statement.setString(3, false);
        int notificationId = statement.executeUpdate();
        System.out.Println(notificationId + " was successfully sent.");

        return notificationId
    }

    public List<String> readNotification(int userID) {
        statement = null;
        String sql = "SELECT msg FROM Notifications where userID=?"
        statement = connection.prepareStatement(sql);

        statement.setString(1, userID);
        ResultSet result = statement.executeQuery();

        List<String> notifications;
        while(result.next()) {
            notifications.add(result.getString(1));
        }

        sql = "UPDATE Notifications set isSeen=true where userId=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, userID);
        statement.executeUpdate();

        return notifications;
    }
}