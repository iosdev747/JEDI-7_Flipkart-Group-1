package com.flipkart.dao;

import java.sql.*;

import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;
import com.flipkart.constant.SQLConstant;
import com.flipkart.exception.*;


public class UserDaoOperation implements UserDaoInterface{

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "12345678";
    private static Logger logger = Logger.getLogger(UserDaoOperation.class);

    public UserDaoOperation(){      // in future may be changed to private

    }

    @Override
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VERIFY_CREDENTIAL);
            preparedStatement.setString(1,String.valueOf(userId));

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                conn.close();
                throw new UserNotFoundException(Integer.toString(userId));
            }

            else if(password.equals(resultSet.getString("paswrd"))){
                conn.close();
                return true;
            }
            else {
                conn.close();
                return false;
            }
        }
        catch(Exception e){
            logger.error("There is an Error verifyCredential : "+ e.getMessage());
        }
        finally{
            logger.debug("Who Knows What happens verifyCredential");
        }
        return false;
    }

    @Override
    public boolean updatePassword(int userId, String newPassword){

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.UPDATE_PASSWORD);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,String.valueOf(userId));

            int row = preparedStatement.executeUpdate();
            conn.close();

            if(row==1){
                return true;
            }
            else {
                return false;
            }

        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
        finally{
            logger.debug("This Finally is to update password");
        }

        return false;
    }

}
