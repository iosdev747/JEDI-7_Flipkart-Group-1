package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.constant.SQLConstant;
import com.flipkart.exception.*;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;


public class RegistrationDaoOperation implements RegistrationDaoInterface {

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "12345678";
    private static Logger logger = Logger.getLogger(RegistrationDaoOperation.class);

    public RegistrationDaoOperation(){ // In future may be change to private

    }

    @Override
    public boolean addCourse(String courseId, String studentId) throws SQLException{

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.REGISTER_COURSE);
            preparedStatement.setString(1,courseId);
            preparedStatement.setString(2, studentId);
            preparedStatement.executeUpdate();

            conn.close();
            return true;
        }
        catch(SQLException e){
            logger.info( e.getMessage());
        }
        catch(Exception e){
            logger.info("There is an Error : "+ e.getMessage());
        }

        return false;
    }

    @Override
    public boolean dropCourse(String courseId, String studentId) throws SQLException{

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.DROP_REGISTER_COURSE);
            preparedStatement.setString(1,courseId);
            preparedStatement.setString(2, studentId);
            preparedStatement.executeUpdate();

            conn.close();
            return true;
        }
        catch(SQLException e){
            logger.info(e.getMessage());
        }
        catch(Exception e){
            logger.info("There is an Error : "+ e.getMessage());
        }

        return false;
    }


    @Override
    public List<Course> viewCourse() throws SQLException{

        List<Course> courseList = new ArrayList<Course>();

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VIEW_ALL_COURSES);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                Course course = new Course();
                course.setCourseId(result.getString("courseID"));
                course.setCourseName(result.getString("courseName"));
                course.setCredit(result.getInt("credit"));
                course.setProfessorEmpId(result.getString("professorEmpID"));
                course.setFee(result.getDouble("fee"));

                courseList.add(course);
            }

            conn.close();

        }
        catch(SQLException e){
            logger.info(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

        return courseList;
    }

    @Override
    public List<Course> viewRegisterCourse(String studentId) throws SQLException{
        logger.debug("-----------Viewing Registered Courses----------");
        List<Course> courseList = new ArrayList<Course>();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VIEW_REGISTER_COURSES);
            preparedStatement.setString(1, studentId);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                Course course = new Course();
                course.setCourseId(result.getString("courseID"));
                course.setCourseName(result.getString("courseName"));
                course.setCredit(result.getInt("credit"));
                course.setProfessorEmpId(result.getString("professorEmpID"));
                course.setFee(result.getDouble("fee"));

                courseList.add(course);
            }


            conn.close();
        }
        catch(SQLException e){
            logger.info(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

        return courseList;
    }


    @Override
    public double calculate(String studentId) throws SQLException{
        double amount = 0;

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.CALCULATE_FEE);
            preparedStatement.setString(1, studentId);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            amount = rs.getDouble(1);

            conn.close();
        }
        catch(SQLException e){
            logger.info(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

        return amount;
    }

    @Override
    public int numOfRegisteredCourses(String studentId) throws SQLException{

        int numCol = 0;

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.CALCULATE_NO_OF_COURSE);
            preparedStatement.setString(1, studentId);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            numCol = rs.getInt(1);

            conn.close();

        }
        catch (SQLException e){
            logger.info(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

        return numCol;
    }


    // Isme Query ke baad jo comment ha usse check kar lo ek baar
    @Override
    public boolean isRegistered(String courseId, String studentId) throws SQLException{

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.REGISTER_IN_ENROLL);
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, courseId);

            ResultSet result = preparedStatement.executeQuery();

            // check is there is only one row in table then true,  can apply better logic?
            result.next();

            if(result.next()){
                conn.close();
                return true;
            }

            conn.close();

        }
        catch(SQLException e){
            logger.info(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error in isRegister : "+ e.getMessage());
        }

        return false;
    }

}
