package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLConstant;
import com.flipkart.exception.StudentNotAddedException;


// there may be some extra conn.close() statments so remove if it feel redundant

public class StudentDaoOperation implements StudentDaoInterface{

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "12345678";

    public StudentDaoOperation() {    // In future may be change to private
    }

    @Override
    public boolean addStudent(Student student) throws StudentNotAddedException {

        // let get all the details from the student first
        int studentID = student.getStudentId();   // also change this to string if studentId in db is String
        int batch = student.getBatch();
        String branch = student.getBranch();
        boolean isApproved = student.isApproved();

        // now get the user details
        int userID = student.getUserID();
        String name = student.getName();
        String password = student.getPassword();
        String address = student.getAddress();

        try {

            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);

            // since student is dependent on user first insert user
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ADD_USER);
            preparedStatement.setString(1, String.valueOf(userID));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, address);
            // execute it to add to the userDetail table
            int rows = preparedStatement.executeUpdate();
            if(rows == 1){
                // now add the Student
                PreparedStatement preparedStatement2 = conn.prepareStatement(SQLConstant.ADD_STUDENT);
                preparedStatement2.setString(1, String.valueOf(studentID));
                preparedStatement2.setString(2, branch);
                preparedStatement2.setString(3, String.valueOf(batch));
                preparedStatement2.setString(4, String.valueOf(userID));

                preparedStatement2.executeUpdate();
            }
            conn.close();
            return true;
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
            throw new StudentNotAddedException(studentID);
        }
        finally{
            System.out.println("This Finally is to AddStudent");
        }

        return false;
    }


    // also change it to string is studentId is String in db
    @Override
    public int getStudentId(int userId){

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_STUDENT_ID);
            preparedStatement.setString(1, String.valueOf(userId));
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                int studentId = result.getInt("studentID");
                conn.close();
                return studentId;
                //return result.getInt("studentID");  // return result.getString("studentID);  //uncomment it otherwise
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error getStudentID : "+ e.getMessage());
        }
        return -1; // return "No student added"   // uncomment it if string
    }

    @Override
    public List<Grade> getGrade(int studentId){
        List<Grade> gradeList = new ArrayList<Grade>();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_STUDENT_GRADE);
            preparedStatement.setString(1, String.valueOf(studentId));

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                gradeList.add(new Grade(result.getInt("studentID"), result.getString("courseID"), result.getDouble("grade")));

            }
           conn.close();

        }
        catch(Exception e){
            System.out.println("There is an Error getGrade : "+ e.getMessage());
        }
        finally{
            System.out.println("This Finally is to getGrade");
        }

        return gradeList;
    }

    /*
    // uncomment it if is Approved is implemented and added to Student database
    // the sql command is already there
    @Override
    public boolean isApproved(int studentId){
        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.IS_APPROVED);
            preparedStatement.setString(1, String.valueOf(studentId));

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                return rs.getBoolean("isApproved");
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error : "+ e.getMessage());
        }
        finally{
            System.out.println("This Finally is to getGrade");
        }
        return false;
    }
     */


    @Override
    public boolean verifyStudent(int userId){


        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VERIFY_STUDENT);
            preparedStatement.setString(1, String.valueOf(userId));

            ResultSet result = preparedStatement.executeQuery();

            result.next();

            int numRow = result.getInt(1);

            if(numRow == 1) {
               conn.close();
                return true;
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println("There is an Error verifyStudent : "+ e.getMessage());
        }
        return false;
    }
}
