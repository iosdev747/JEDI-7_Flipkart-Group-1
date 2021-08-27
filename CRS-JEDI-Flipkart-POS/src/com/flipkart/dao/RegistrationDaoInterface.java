package com.flipkart.dao;

import java.util.*;
import java.sql.SQLException;

import com.flipkart.exception.*;
import com.flipkart.bean.Course;


public interface RegistrationDaoInterface {

    /**
     * Add course
     * @param courseId
     * @param studentId
     * @return true/false
     * @throws SQLException
     */
    public boolean addCourse(String courseId, String studentId) throws SQLException;

    /**
     * Drop Course
     * @param courseId
     * @param studentId
     * @return true/false
     * @throws SQLException
     */
    public boolean dropCourse(String courseId, String studentId) throws SQLException;

    /**
     * View courses
     * @return list of courses
     * @throws SQLException
     */
    public List<Course> viewCourse() throws SQLException;

    /**
     * view registered courses
     * @param studentId
     * @return list of registered courses
     * @throws SQLException
     */
    public List<Course> viewRegisterCourse(String studentId) throws SQLException;

    /**
     * calculate fees
     * @param studentId
     * @return fees
     * @throws SQLException
     */
    public double calculate(String studentId) throws SQLException;

    /**
     * view number of registered courses
     * @param studentId
     * @return number of registered courses
     * @throws SQLException
     */
    public int numOfRegisteredCourses(String studentId) throws SQLException;

    /**
     * view number of registered courses
     * @param studentId
     * @return true/false
     * @throws SQLException
     */
    public boolean isRegistered(String courseId, String studentId) throws SQLException;


}
