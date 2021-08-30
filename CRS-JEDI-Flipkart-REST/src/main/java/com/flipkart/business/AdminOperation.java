package com.flipkart.business;

import java.util.*;
import java.sql.SQLException;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.*;

import org.apache.log4j.Logger;


public class AdminOperation implements AdminInterface{

    /**
     * Constructor
     */
    public AdminOperation() {   // In future may be change to private
    }


    public List<Course> viewCourse() {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("View Course");
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        try {
            return registrationInterface.viewCourse();
        } catch (SQLException e) {
            logger.debug(e.getMessage());
        }
        return null;
    }


    /**
     * Method to delete course
     * @param courseId
     * @return
     */
    @Override
    public void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException{
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Deleting Course " + courseId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        adminInterface.deleteCourse(courseId);
    }

    /**
     * Method to add course
     * @param: courseId, courseName, credit, professorEmpId, fee
     * @return
     */
    @Override
    public void addCourse(String courseId, String courseName, int credit, String professorEmpId, double fee) throws CourseFoundException{
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Adding Course " + courseId);
        Course course = new Course(courseId, courseName, credit, professorEmpId, fee);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        try{
            adminInterface.addCourse(course);
        }
        catch(CourseFoundException e) {
            throw e;
        }
    }


    @Override
    public List<Student> viewPendingAdmissions(){

        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        return adminDaoInterface.viewPendingAdmissions();

    }

    @Override
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException{

        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();

        try{
            adminDaoInterface.approveStudent(studentId);
        }
        catch(StudentNotFoundForApprovalException e) {
            throw e;
        }
    }


    /**
     * Method to assign add professor
     * @param professor
     * @return
     */
    @Override
    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException{
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Adding Professor " + professor.getProfessorEmpId());
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        try{
            adminInterface.addProfessor(professor);
        }
        catch(ProfessorNotAddedException | UserIdAlreadyInUseException e) {
            throw e;
        }
    }


    /**
     * Method to add a user
     * @param user
     * @return
     */
    @Override
    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException{
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Adding User " + user.getUserID());
        AdminDaoInterface adminInterface = new AdminDaoOperation();

        try{
            adminInterface.addUser(user);
        }
        catch(UserNotAddedException | UserIdAlreadyInUseException e){
            throw e;
        }

    }

    /**
     * Method to assign course to professor
     * @param courseId, professorEmpId
     * @return
     */
    @Override
    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException{
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Assigning Course " + courseId + " to professor with ID " + professorEmpId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        try{
            adminInterface.assignCourse(courseId, professorEmpId);
        }
        catch(CourseNotFoundException | UserNotFoundException e){
            throw e;
        }
        //adminInterface.assignCourse(courseId, professorEmpId);
    }

    /**
     * Method to view list of professors
     * @param
     * @return List<Professor>
     */
    @Override
    public List<Professor> viewProfessor(){
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Viewing Professors ");
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.viewProfessor();
    }

    /**
     * Method to get verify
     * @param userId
     * @return
     */
    @Override
    public boolean verifyProfessor(int userId){
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Verifying Professor " + userId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.verifyProfessor(userId);
    }

    /**
     * Method to get admin
     * @param userId
     * @return admin's user ID
     */
    @Override
    public String getAdminId(int userId){
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Getting Admin with ID : " + userId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.getAdminId(userId);
    }

}
