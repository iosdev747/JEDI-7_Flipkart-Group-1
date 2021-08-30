package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.*;
import java.sql.SQLException;

public interface StudentInterface {

    /**
     * Registration
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
    public boolean register(int userID, String name, String password, String address, String studentId, int batch, String branch, boolean isApproved) throws StudentNotRegisteredException;

    /**
     * get student id
     * @param userId
     * @return
     */
    public String getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    /**
     * view grade card
     * @param studentId
     * @return
     * @throws SQLException
     */
    public List<Grade> getGrade(String studentId) throws SQLException;
    // here also change input to String if studentId is String in db

    /**
     * is student approved?
     * @param studentId
     * @return
     */
    public boolean isApproved(String studentId);   // --> this is not present in the database either left it or add to database

    // here also change input to String if studentId is String in db
    /**
     * verify student
     * @param userId
     * @return
     */
    public boolean verifyStudent(int userId);

}
