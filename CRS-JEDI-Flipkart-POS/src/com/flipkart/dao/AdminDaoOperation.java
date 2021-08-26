package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLConstant;


public class AdminDaoOperation implements AdminDaoInterface{

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "12345678";

    public AdminDaoOperation() {    // In future may be change to private
    }

    @Override
    public void deleteCourse(String courseId){

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);

            // Delete the course from Database, it will be cascade to EnrolledStudent
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.DELETE_COURSE);
            preparedStatement.setString(1,courseId);
            preparedStatement.executeUpdate();

            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }
    }

    public void addCourse(Course course){
        // first take details from the course
        String courseId = course.getCourseId();
        String courseName = course.getCourseName();
        int credit = course.getCredit();
        int professorEmpId = course.getProfessorEmpId();
        double fee = course.getFee();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ADD_COURSE);
            preparedStatement.setString(1, courseId);
            preparedStatement.setString(2, courseName);
            preparedStatement.setString(3, String.valueOf(credit));
            preparedStatement.setString(4, String.valueOf(professorEmpId));
            preparedStatement.setString(5, String.valueOf(fee));

            preparedStatement.executeUpdate();

            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

    }

    @Override
    public void addProfessor(Professor professor){

        int userId = professor.getUserID();
        String name = professor.getName();
        String password = professor.getPassword();
        String address = professor.getAddress();
        String department = professor.getDepartment();
        int professorEmpId = professor.getProfessorEmpId();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            // since student is dependent on user first insert user
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ADD_USER);
            preparedStatement.setString(1, String.valueOf(userId));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, address);

            // execute it to add to the userDetail table
            int rows = preparedStatement.executeUpdate();
            if(rows == 1){
                // now add the Student
                PreparedStatement preparedStatement2 = conn.prepareStatement(SQLConstant.ADD_PROFESSOR);
                preparedStatement2.setString(1, String.valueOf(userId));
                preparedStatement2.setString(2, String.valueOf(professorEmpId));
                preparedStatement2.setString(3, department);

                preparedStatement2.executeUpdate();
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

    }

    @Override
    public void addUser(User userR){
        int userId = userR.getUserID();
        String name = userR.getName();
        String password = userR.getPassword();
        String address = userR.getAddress();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            // since student is dependent on user first insert user
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ADD_USER);
            preparedStatement.setString(1, String.valueOf(userId));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, address);

            // execute it to add to the userDetail table
            preparedStatement.executeUpdate();

            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }
    }


    @Override
    public void assignCourse(String courseId, int professorEmpId){

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ASSIGN_COURSE);
            preparedStatement.setString(1, String.valueOf(professorEmpId));
            preparedStatement.setString(2, courseId);

            preparedStatement.executeUpdate();

            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }
    }

    @Override
    public List<Professor> viewProfessor() {

        List<Professor> professorList = new ArrayList<Professor>();

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VIEW_PROFESSOR);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                Professor professor = new Professor();
                professor.setUserID(result.getInt("userID"));
                professor.setProfessorEmpId(result.getInt("professorEmpID"));
                professor.setName(result.getString("userName"));
                professor.setAddress(result.getString("address"));
                professor.setPassword(result.getString("pswrd"));
                professor.setDepartment(result.getString("department"));

                professorList.add(professor);
            }

            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }

        return professorList;
    }

    @Override
    public boolean verifyProfessor(int userId){
        boolean flag = false;

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VERIFY_ADMIN);
            preparedStatement.setString(1, String.valueOf(userId));

            ResultSet result = preparedStatement.executeQuery();

            result.next();

            int numRow = result.getInt(1);

            if(numRow == 1) flag = true;
            conn.close();

        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }
        return flag;
    }

    @Override
    public int getAdminId(int userId){
        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_ADMIN_ID);
            preparedStatement.setString(1, String.valueOf(userId));
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                int empId = result.getInt("empID");  // return result.getString("empID);  //uncomment it otherwise
                conn.close();
                return empId;
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }
        return -1; // return "No Admin added"   // uncomment it if string
    }
}
