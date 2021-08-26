package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List ;

public class NotificationDaoOperation implements NotificationDaoInterface{

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "12345678";

    public String sendNotification(int userId, String msg) {
        int notificationId = 0;
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO Notifications(userID, msg, isSeen) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(userId));
            statement.setString(2, msg);
            statement.setString(3, "No");
            notificationId = statement.executeUpdate();
            System.out.println(notificationId + " was successfully sent.");
            connection.close();
        } catch (Exception e) {
            System.out.println("EXCEPTION OCCURED");
        }
        return notificationId;
    }

    public ArrayList<String> readNotification(int userID) {
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
            System.out.println("Exception Occured");
        }

        return notifications;
    }
}