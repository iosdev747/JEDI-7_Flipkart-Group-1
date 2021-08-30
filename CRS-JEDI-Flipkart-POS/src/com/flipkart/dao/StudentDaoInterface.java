package com.flipkart.dao;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

import java.sql.SQLException;
import java.util.List;


public interface StudentDaoInterface {

    /**
     * Add student
     *
     * @param student
     * @return true/false
     * @throws StudentNotRegisteredException
     */
    boolean addStudent(Student student) throws StudentNotRegisteredException;

    /**
     * get student ID
     *
     * @param userId
     * @return student ID
     */
    String getStudentId(int userId);
    //  can change return to string if studentId in Db is string

    /**
     * get grade card
     *
     * @param studentId
     * @return grade card
     * @throws SQLException
     */
    List<Grade> getGrade(String studentId) throws SQLException;
    // here also change input to String if studentId is String in db

    /**
     * is student approved?
     *
     * @param studentId
     * @return true/false
     */
    boolean isApproved(String studentId);   // --> this is not present in the database either left it or add to database
    // here also change input to String if studentId is String in db

    /**
     * verify student
     *
     * @param userId
     * @return true/false
     */
    boolean verifyStudent(int userId);
}
