package com.flipkart.dao;

import com.flipkart.constant.SQLConstant;
import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDaoOperation implements UserDaoInterface {

    private static final String url = SQLConstant.DB_URL;
    private static final String user = SQLConstant.DB_USER;
    private static final String pass = SQLConstant.DB_PASS;
    private static final Logger logger = Logger.getLogger(UserDaoOperation.class);

    /**
     * Constructor
     */
    public UserDaoOperation() {

    }

    /**
     * verify credentials
     *
     * @param userId
     * @param password
     * @return true/false
     * @throws UserNotFoundException
     */
    @Override
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VERIFY_CREDENTIAL);
            preparedStatement.setString(1, String.valueOf(userId));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                conn.close();
                throw new UserNotFoundException(Integer.toString(userId));
            } else if (password.equals(resultSet.getString("paswrd"))) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }
        } catch (Exception e) {
            logger.error("There is an Error verifyCredential : " + e.getMessage());
        } finally {
            logger.debug("Who Knows What happens verifyCredential");
        }
        return false;
    }

    /**
     * update password
     *
     * @param userId
     * @param newPassword
     * @return true/false
     */
    @Override
    public boolean updatePassword(int userId, String newPassword) {

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.UPDATE_PASSWORD);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, String.valueOf(userId));

            int row = preparedStatement.executeUpdate();
            conn.close();

            return row == 1;

        } catch (Exception e) {
            logger.error("There is an Error : " + e.getMessage());
        } finally {
            logger.debug("This Finally is to update password");
        }

        return false;
    }

}
