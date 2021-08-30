package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.exception.StudentNotRegisteredException;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {
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
    boolean register(int userID, String name, String password, String address, String studentId, int batch, String branch, boolean isApproved) throws StudentNotRegisteredException;

    /**
     * Method to get Student ID from User ID
     *
     * @param userId
     * @return Student ID
     */
    String getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    /**
     * Method to get the List of Grades for a particular student.
     *
     * @param studentId
     * @return List of Grades for a particular student.
     */
    List<Grade> getGrade(String studentId) throws SQLException;
    // here also change input to String if studentId is String in db

    /**
     * Method to verify that the student has successfully registered
     *
     * @param studentId
     * @return
     */
    boolean isApproved(String studentId);   // --> this is not present in the database either left it or add to database

    // here also change input to String if studentId is String in db

    /**
     * Method to verify that the User is a student.
     *
     * @param userId
     * @return Student ID
     */
    boolean verifyStudent(int userId);

}
