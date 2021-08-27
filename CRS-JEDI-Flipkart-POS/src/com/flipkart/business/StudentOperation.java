package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.*;

import org.apache.log4j.Logger;

import java.util.*;
import java.sql.SQLException;


public class StudentOperation implements StudentInterface {

    public StudentOperation() { // In future may be change to private
    }

    /**
     * Method to register a student, although student can't login until it's approved by admin
     *
     * @param name
     * @param userID
     * @param password
     * @param batch
     * @param branch
     * @param address
     * @param studentId
     * @param isApproved
     * @return boolean to show that student has successfully registered.
     * @throws StudentNotRegisteredException
     */
    @Override
    public boolean register(int userID, String name, String password, String address, String studentId, int batch, String branch, boolean isApproved) throws StudentNotRegisteredException {
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Initiating Registration for Student with ID : " + studentId);
        boolean flag = false;
        try {
            Student student = new Student(userID, name, password, address, studentId, batch, branch, isApproved);
            StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
            studentDaoInterface.addStudent(student);
            flag = true;
        } catch (StudentNotRegisteredException e) {
            throw e;
        }

        return flag;
    }

    /**
     * Method to get Student ID from User ID
     *
     * @param userId
     * @return Student ID
     */
    @Override
    public String getStudentId(int userId) {
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Getting Student ID for user ID: " + Integer.toString(userId));
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.getStudentId(userId);
    }

    /**
     * Method to get the List of Grades for a particular student.
     *
     * @param studentId
     * @return List of Grades for a particular student.
     */
    @Override
    public List<Grade> getGrade(String studentId) throws SQLException {
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Grade Card for Student with ID : " + studentId);
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();

        List<Grade> gradeList = new ArrayList<Grade>();

        try {
            gradeList = studentDaoInterface.getGrade(studentId);
        } catch (SQLException e) {
            throw e;
        }
        return gradeList;
    }

    /**
     * Method to verify that the student has successfully registered
     *
     * @param studentId
     * @return
     */
    @Override
    public boolean isApproved(String studentId) {

        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.isApproved(studentId);

    }

    /**
     * Method to verify that the User is a student.
     *
     * @param userId
     * @return Student ID
     */
    @Override
    public boolean verifyStudent(int userId) {
        Logger logger = Logger.getLogger(StudentOperation.class);
        logger.debug("Verifying Student with ID : " + userId);
        StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
        return studentDaoInterface.verifyStudent(userId);
    }

}
