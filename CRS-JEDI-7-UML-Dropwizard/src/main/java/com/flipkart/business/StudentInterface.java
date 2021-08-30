package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.exception.StudentNotRegisteredException;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {

    /**
     * Registration
     *
     * @param userID
     * @param name
     * @param password
     * @param address
     * @param studentId
     * @param batch
     * @param branch
     * @param isApproved
     * @return
     * @throws StudentNotRegisteredException
     */
    boolean register(int userID, String name, String password, String address, String studentId, int batch, String branch, boolean isApproved) throws StudentNotRegisteredException;

    /**
     * get student id
     *
     * @param userId
     * @return
     */
    String getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    /**
     * view grade card
     *
     * @param studentId
     * @return
     * @throws SQLException
     */
    List<Grade> getGrade(String studentId) throws SQLException;
    // here also change input to String if studentId is String in db

    /**
     * is student approved?
     *
     * @param studentId
     * @return
     */
    boolean isApproved(String studentId);   // --> this is not present in the database either left it or add to database

    // here also change input to String if studentId is String in db

    /**
     * verify student
     *
     * @param userId
     * @return
     */
    boolean verifyStudent(int userId);

}
