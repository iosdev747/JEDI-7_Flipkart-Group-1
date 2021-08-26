package com.flipkart.dao;

import java.sql.*;
import java.util.*;
import java.sql.SQLException;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLConstant;
import com.flipkart.exception.GradeNotAddedException ;
import org.apache.log4j.Logger;


public class ProfessorDaoOperation implements ProfessorDaoInterface{

    private static String url = "jdbc:mysql://localhost:3306/JEDI-7-CRS";
    private static String user = "root";
    private static String pass = "12345678";
    private static Logger logger = Logger.getLogger(ProfessorDaoOperation.class);

    public ProfessorDaoOperation() {   // In future may be change to private
    }

    // here also change the professorEmpId to string if it is in db
    @Override
    public List<Course> getCoursesByProfessor(String professorEmpId) {

        List<Course> courseList = new ArrayList<Course>();

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_PROF_COURSE);
            preparedStatement.setString(1,professorEmpId);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                courseList.add(new Course(rs.getString("courseID"), rs.getString("courseName"), rs.getInt("credit"), rs.getString("professorEmpId"), rs.getDouble("fee")));
                // here change getInt to getString for professor
            }

            conn.close();
        }
        catch(SQLException e){
            logger.error(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

        return courseList;
    }

    // here also change it to professorEmpId to string if in db
    @Override
    public List<EnrolledStudent> getEnrolledStudent(String professorEmpId){

        List<EnrolledStudent> enrolledList = new ArrayList<EnrolledStudent>();

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_ENROL_STUDENT);
            preparedStatement.setString(1,professorEmpId);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                enrolledList.add(new EnrolledStudent(result.getString("courseID"), result.getString("studentID")));
            }

            conn.close();
        }
        catch(SQLException e){
            logger.error(e.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

        return enrolledList;
    }

    // studentId can be change to String if db is String
    @Override
    public boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException{

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ADD_GRADE);
            preparedStatement.setString(1, String.valueOf(grade));
            preparedStatement.setString(2, String.valueOf(courseId));
            preparedStatement.setString(3, String.valueOf(studentId));

            preparedStatement.executeUpdate();

            conn.close();
            return true;
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
            throw new GradeNotAddedException(studentId);
        }

        //return false;
    }

    // change professorEmpId to String if in db it is String
    @Override
    public String getProfessorName(String professorEmpId) {
        logger.debug("---------Getting Name of Professor--------");
        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_PROF_NAME);
            preparedStatement.setString(1, professorEmpId);

            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                conn.close();
                return result.getString("userName");  // return result.getString("studentID);  //uncomment it otherwise
            }

            conn.close();
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());

        }

        return "No Professor of ID: "+professorEmpId;
    }

    @Override
    public boolean verifyProfessor(int userId){
        logger.debug("---------Verifying Professor--------");
        boolean flag = false;

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VERIFY_PROFESSOR);
            preparedStatement.setString(1, String.valueOf(userId));

            ResultSet result = preparedStatement.executeQuery();

            result.next();

            int numRow = result.getInt(1);

            if(numRow == 1) flag = true;
            conn.close();

        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
        return flag;
    }

    @Override
    public String getProfessorId(int userId){
        logger.debug("---------Getting Professor--------");
        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_PROFESSOR_ID);
            preparedStatement.setString(1, String.valueOf(userId));
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                String profId = result.getString("professorEmpID");  // return result.getString("professorID);  //uncomment it otherwise
                conn.close();
                return  profId;
            }
            conn.close();
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
        return "Not Right user"; // return "No pofessor added"   // uncomment it if string

    }
}
