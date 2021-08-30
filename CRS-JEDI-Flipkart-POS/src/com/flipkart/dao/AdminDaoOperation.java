package com.flipkart.dao;

import java.sql.*;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.UserOperation;
import com.flipkart.constant.SQLConstant;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;


public class AdminDaoOperation implements AdminDaoInterface{

    private static String url = SQLConstant.DB_URL;
    private static String user = SQLConstant.DB_USER;
    private static String pass = SQLConstant.DB_PASS;
    private static Logger logger = Logger.getLogger(AdminDaoOperation.class);

    /**
     * Constructor
     */
    public AdminDaoOperation() {    // In future may be change to private
    }

    /**
     * Method to delete course
     * @param courseId
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     */
    @Override
    public void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException {


        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);

            // Delete the course from Database, it will be cascade to EnrolledStudent
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.DELETE_COURSE);
            preparedStatement.setString(1,courseId);
            int row = preparedStatement.executeUpdate();

            logger.info(row + " entries deleted.");

            if(row == 0){
                logger.error(courseId + " not in catalog!");
                conn.close();
                throw new CourseNotFoundException(courseId);
            }

            conn.close();
        }
        catch(SQLException e){
            logger.error(e.getMessage());
            throw new CourseNotDeletedException(courseId);
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
            throw new CourseNotDeletedException(courseId);
        }
    }

    /**
     * Method to add course
     * @param course
     * @throws CourseFoundException
     */
    public void addCourse(Course course) throws CourseFoundException {

        // first take details from the course
        String courseId = course.getCourseId();
        String courseName = course.getCourseName();
        int credit = course.getCredit();
        String professorEmpId = course.getProfessorEmpId();
        double fee = course.getFee();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ADD_COURSE);
            preparedStatement.setString(1, courseId);
            preparedStatement.setString(2, courseName);
            preparedStatement.setString(3, String.valueOf(credit));
            preparedStatement.setString(4, professorEmpId);
            preparedStatement.setString(5, String.valueOf(fee));

            int row = preparedStatement.executeUpdate();

            logger.info(row + " Course added");
            if(row == 0){
                logger.info("Course with courseCode: " + courseId + "not added to catalog.");
                conn.close();
                throw new CourseFoundException(courseId);
            }
            conn.close();
        }
        catch(SQLException se) {
            logger.error(se.getMessage());
            throw new CourseFoundException(courseId);
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

    }

    /**
     * Method to view pending admissions
     * @return list of students
     */
    @Override
    public List<Student> viewPendingAdmissions(){

        List<Student> studentList = new ArrayList<Student>();

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VIEW_PENDING_ADMISSION_QUERY);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int userId = result.getInt("userID");
                String name = result.getString("userName");
                String password = result.getString("paswrd");
                String address = result.getString("address");
                String studentId = result.getString("studentID");
                int batch = result.getInt("currentYear");
                String branch = result.getString("department");


                Student student = new Student(userId, name,password, address,studentId,batch,branch,false);
                studentList.add(student);
            }

            conn.close();
        }
        catch(Exception e){
            logger.error("There is an Error in viewPending : "+ e.getMessage());
        }


        return studentList;
    }

    /**
     * Method to approve student registration
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */
    @Override
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException {

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.APPROVE_STUDENT_QUERY);
            preparedStatement.setString(1, studentId);

            int rows = preparedStatement.executeUpdate();
            logger.info("-----------Student Approval---------");
            if(rows == 0){
                // here throw an error StudentNotFoundForApprovalException(studentId)
                conn.close();
                throw new StudentNotFoundForApprovalException(Integer.parseInt(studentId));
            }

            conn.close();
        }
        catch(SQLException se) {
            logger.error(se.getMessage());
        }
        catch(Exception e){
            logger.error("There is an Error in approveStudent : "+ e.getMessage());
        }
    }

    /**
     * Method to add professor
     * @param professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    @Override
    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException {

        int userId = professor.getUserID();
        String name = professor.getName();
        String password = professor.getPassword();
        String address = professor.getAddress();
        String department = professor.getDepartment();
        String professorEmpId = professor.getProfessorEmpId();

        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            // since student is dependent on user first insert user
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ADD_USER);
            preparedStatement.setString(1, String.valueOf(userId));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, address);

            //logger.info("----------Adding Professor------------");
            // execute it to add to the userDetail table
            int rows = preparedStatement.executeUpdate();
            logger.info("----------Adding Professor------------");
            if(rows == 1){
                // now add the Student
                PreparedStatement preparedStatement2 = conn.prepareStatement(SQLConstant.ADD_PROFESSOR);
                preparedStatement2.setString(1, String.valueOf(userId));
                preparedStatement2.setString(2, professorEmpId);
                preparedStatement2.setString(3, department);

                int row2 =preparedStatement2.executeUpdate();
                if(row2 == 0){
                    logger.error("Professor with professorId: " + professorEmpId + " not added.");
                    conn.close();
                    throw new ProfessorNotAddedException(professorEmpId);
                }
            }
            else{
                logger.info(userId + " Not Added");
                conn.close();
                throw new UserIdAlreadyInUseException(Integer.toString(userId));
            }
            conn.close();
        }
        catch(SQLException se) {

            logger.error(se.getMessage());
            throw new UserIdAlreadyInUseException(professorEmpId);

        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

    }

    /**
     * Method to add user
     * @param user
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    @Override
    public void addUser(User userR) throws UserNotAddedException, UserIdAlreadyInUseException{

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

            //logger.info("------------Adding User----------");
            // execute it to add to the userDetail table
            int row = preparedStatement.executeUpdate();
            logger.info(row + " user added.");
            if(row == 0){
                logger.error("User with userId: " + userId + " not added.");
                conn.close();
                throw new UserNotAddedException(Integer.toString(userId));
            }
            logger.info("User with userId: " + userId + " added.");
            conn.close();
        }
        catch(SQLException se) {
            logger.error(se.getMessage());
            throw new UserIdAlreadyInUseException(Integer.toString(userId));
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
    }

    /**
     * Method to assign course
     * @param courseId
     * @param professorEmpId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    @Override
    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException{
        //logger.debug("-----------Assigning Course to Professor---------");
        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.ASSIGN_COURSE);
            preparedStatement.setString(1, professorEmpId);
            preparedStatement.setString(2, courseId);

            int row = preparedStatement.executeUpdate();

            logger.info(row + " course assigned.");
            if(row == 0) {
                logger.error(courseId + " not found");
                conn.close();
                throw new CourseNotFoundException(courseId);
            }
            conn.close();
        }
        catch(SQLException se) {
            logger.error(se.getMessage());
            throw new UserNotFoundException(professorEmpId);
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
    }

    /**
     * Method to view professors list
     * @return list of professors
     */
    @Override
    public List<Professor> viewProfessor() {
        //logger.debug("-----------Viewing Professor---------");
        List<Professor> professorList = new ArrayList<Professor>();

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VIEW_PROFESSOR);

            ResultSet result = preparedStatement.executeQuery();
            logger.info("-----------Viewing Professor---------");
            while(result.next()){
                // change 1st getInt  to getString   if studentID is String
                Professor professor = new Professor();
                professor.setUserID(result.getInt("userID"));
                professor.setProfessorEmpId(result.getString("professorEmpID"));
                professor.setName(result.getString("userName"));
                professor.setAddress(result.getString("address"));
                professor.setPassword(result.getString("pswrd"));
                professor.setDepartment(result.getString("department"));

                professorList.add(professor);
            }

            conn.close();
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }

        return professorList;
    }

    /**
     * Method to verify professor
     * @param userId
     * @return true/false
     */
    @Override
    public boolean verifyAdmin(int userId){
        //logger.debug("-----------Verifying Professor---------");
        boolean flag = false;

        try{
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.VERIFY_ADMIN);
            preparedStatement.setString(1, String.valueOf(userId));

            ResultSet result = preparedStatement.executeQuery();

            result.next();

            int numRow = result.getInt(1);
            logger.info("-----------Verifying Professor---------");
            if(numRow == 1) flag = true;
            conn.close();

        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
        return flag;
    }

    /**
     * Method to get admin ID
     * @param userId
     * @return admin id
     */
    @Override
    public String getAdminId(int userId){
       //logger.debug("---------Getting Admin---------");
        try {
            Class.forName("com.mysql.jdbc.Driver");   // see if it will be used

            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement = conn.prepareStatement(SQLConstant.GET_ADMIN_ID);
            preparedStatement.setString(1, String.valueOf(userId));
            ResultSet result = preparedStatement.executeQuery();
            logger.info("---------Getting Admin---------");
            if(result.next()){
                String empId = result.getString("empID");  // return result.getString("empID);  //uncomment it otherwise
                conn.close();
                return empId;
            }
            conn.close();
        }
        catch(Exception e){
            logger.error("There is an Error : "+ e.getMessage());
        }
        return "No Admin by this name"; // return "No Admin added"   // uncomment it if string
    }
}
