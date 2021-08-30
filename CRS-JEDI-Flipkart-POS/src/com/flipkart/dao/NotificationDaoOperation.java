package com.flipkart.dao;

import com.flipkart.constant.SQLConstant;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List ;

public class NotificationDaoOperation implements NotificationDaoInterface{

    private static String url = SQLConstant.DB_URL;
    private static String user = SQLConstant.DB_USER;
    private static String pass = SQLConstant.DB_PASS;
    private static Logger logger = Logger.getLogger(NotificationDaoOperation.class);

    /**
     * send notification
     * @param userId
     * @param msg: Message to be sent
     * @return notification ID
     */
    public String sendNotification(int userId, String msg) {
        //logger.debug("-------------Sending Notification--------");
        int notificationId = 0;
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO Notifications(userID, msg, isSeen) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(userId));
            statement.setString(2, msg);
            statement.setString(3, "No");
            notificationId = statement.executeUpdate();
            logger.info(notificationId + " was successfully sent.");
            connection.close();
        } catch (Exception e) {
            logger.error("EXCEPTION OCCURED");
        }
        return Integer.toString(notificationId);
    }

    /**
     * read notification
     * @param userID: userID to view all notifications for
     * @return notification message
     */
    public ArrayList<String> readNotification(int userID) {
        //logger.debug("-------------Reading Notification--------");
        ArrayList<String> notifications = new ArrayList<String>();
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            String sql = "SELECT msg FROM Notifications where userID=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(userID));
            ResultSet result = statement.executeQuery();
            logger.info("-------------Reading Notification--------");
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