package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.SQLException;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLConstant;
import com.flipkart.exception.StudentNotRegisteredException;
import org.apache.log4j.Logger;


// there may be some extra conn.close() statments so remove if it feel redundant

public class StudentDaoOperation implements StudentDaoInterface{

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "root";
    private static Logger logger = Logger.getLogger(StudentDaoOperation.class);

    public StudentDaoOperation() {    // In future may be change to private
    }

    @Override
    public boolean addStudent(Student student) throws StudentNotRegisteredException {
        logger.debug("---------Adding Student--------");
        // let get all the details from the student first
        String studentID = student.getStudentId();   // also change this to string if studentId in db is String
        int batch = student.getBatch();
        String branch = student.getBranch();
        int isApproved = 0;

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
                preparedStatement2.setString(1, studentID);
                preparedStatement2.setString(2, branch);
                preparedStatement2.setString(3, String.valueOf(batch));
                preparedStatement2.setString(4, String.valueOf(userID));
                preparedStatement2.setString(5, String.valueOf(isApproved));

                preparedStatement2.executeUpdate();
            }
            conn.close();
            return true;
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
            throw new StudentNotRegisteredException(name);
        }

        //return false;
    }


    // also change it to string is studentId is String in db
    @Override
    public String getStudentId(int userId){
        logger.debug("---------Get Student Details--------");
        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_STUDENT_ID);
            preparedStatement.setString(1, String.valueOf(userId));
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                String studentId = result.getString("studentID");
                conn.close();
                return studentId;
                //return result.getInt("studentID");  // return result.getString("studentID);  //uncomment it otherwise
            }
            conn.close();
        }
        catch(Exception e){
            logger.error("There is an Error getStudentID : "+ e.getMessage());
        }
        return "No such student"; // return "No student added"   // uncomment it if string
    }

    @Override
    public List<Grade> getGrade(String studentId) throws SQLException{
        logger.debug("---------Get Grade Card--------");
        List<Grade> gradeList = new ArrayList<Grade>();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_STUDENT_GRADE);
            preparedStatement.setString(1, studentId);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                gradeList.add(new Grade(result.getString("studentID"), result.getString("courseID"), result.getDouble("grade")));

            }
           conn.close();

        }
        catch(SQLException e){
            logger.error(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error getGrade : "+ e.getMessage());
        }
        finally{
            logger.debug("This Finally is to getGrade");
        }

        return gradeList;
    }


    // uncomment it if is Approved is implemented and added to Student database
    // the sql command is already there
    @Override
    public boolean isApproved(String studentId){
        logger.debug("---------Checking if Student is Approved or NOT--------");
        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.IS_APPROVED);
            preparedStatement.setString(1, studentId);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                return rs.getBoolean("isApproved");
            }
            conn.close();
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
        finally{
            logger.debug("This Finally is to getGrade");
        }
        return false;
    }



    @Override
    public boolean verifyStudent(int userId){

        logger.debug("---------Verifying Student--------");
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
            logger.error("There is an Error verifyStudent : "+ e.getMessage());
        }
        return false;
    }
}
