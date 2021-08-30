package com.flipkart.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List ;

public class NotificationDaoOperation implements NotificationDaoInterface{

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "root";
    private static Logger logger = Logger.getLogger(NotificationDaoOperation.class);

    public String sendNotification(int userId, String msg) {
        logger.debug("-------------Sending Notification--------");
        int notificationId = 0;
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO Notifications(userID, msg, isSeen) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(userId));
            statement.setString(2, msg);
            statement.setString(3, "No");
            notificationId = statement.executeUpdate();
            logger.error(notificationId + " was successfully sent.");
            connection.close();
        } catch (Exception e) {
            logger.error("EXCEPTION OCCURED");
        }
        return Integer.toString(notificationId);
    }

    public ArrayList<String> readNotification(int userID) {
        logger.debug("-------------Reading Notification--------");
        ArrayList<String> notifications = new ArrayList<String>();
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            String sql = "SELECT msg FROM Notifications where userID=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(userID));
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                notifications.add(result.getString(1));
            }

            sql = "UPDATE Notifications set isSeen=true where userId=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userID);
            statement.executeUpdate();
        } catch (Exception e) {
            logger.error("Exception Occured");
        }

        return notifications;
    }
}