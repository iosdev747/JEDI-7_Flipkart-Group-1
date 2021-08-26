package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.constant.SQLConstant;


public class RegistrationDaoOperation implements RegistrationDaoInterface {

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "12345678";

    public RegistrationDaoOperation(){ // In future may be change to private

    }

    @Override
    public boolean addCourse(String courseId, int studentId){

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.REGISTER_COURSE);
            preparedStatement.setString(1,courseId);
            preparedStatement.setString(2, String.valueOf(studentId));
            preparedStatement.executeUpdate();

            conn.close();
            return true;
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return false;
    }

    @Override
    public boolean dropCourse(String courseId, int studentId){

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.DROP_REGISTER_COURSE);
            preparedStatement.setString(1,courseId);
            preparedStatement.setString(2, String.valueOf(studentId));
            preparedStatement.executeUpdate();

            conn.close();
            return true;
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return false;
    }


    @Override
    public List<Course> viewCourse(){

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
                course.setProfessorEmpId(result.getInt("professorEmpID"));
                course.setFee(result.getDouble("fee"));

                courseList.add(course);
            }

            conn.close();

        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return courseList;
    }

    @Override
    public List<Course> viewRegisterCourse(int studentId){

        List<Course> courseList = new ArrayList<Course>();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VIEW_REGISTER_COURSES);
            preparedStatement.setString(1, String.valueOf(studentId));

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                Course course = new Course();
                course.setCourseId(result.getString("courseID"));
                course.setCourseName(result.getString("courseName"));
                course.setCredit(result.getInt("credit"));
                course.setProfessorEmpId(result.getInt("professorEmpID"));
                course.setFee(result.getDouble("fee"));

                courseList.add(course);
            }


            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return courseList;
    }


    @Override
    public double calculate(int studentId){
        double amount = 0;

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.CALCULATE_FEE);
            preparedStatement.setString(1, String.valueOf(studentId));

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            amount = rs.getDouble(1);

            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return amount;
    }

    @Override
    public int numOfRegisteredCourses(int studentId){
        int numCol = 0;

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.CALCULATE_NO_OF_COURSE);
            preparedStatement.setString(1, String.valueOf(studentId));

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            numCol = rs.getInt(1);

            conn.close();

        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return numCol;
    }


    // Isme Query ke baad jo comment ha usse check kar lo ek baar
    @Override
    public boolean isRegistered(String courseId, int studentId){

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.REGISTER_IN_ENROLL);
            preparedStatement.setString(1, String.valueOf(studentId));
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
        catch(Exception e){
            System.out.println("There is an Error in isRegister : "+ e.getMessage());
        }

        return false;
    }

}
