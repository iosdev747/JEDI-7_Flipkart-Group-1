package com.flipkart.dao;

import com.flipkart.bean.Course;

import java.sql.SQLException;
import java.util.List;


public interface RegistrationDaoInterface {

    /**
     * Add course
     *
     * @param courseId
     * @param studentId
     * @return true/false
     * @throws SQLException
     */
    boolean addCourse(String courseId, String studentId) throws SQLException;

    /**
     * Drop Course
     *
     * @param courseId
     * @param studentId
     * @return true/false
     * @throws SQLException
     */
    boolean dropCourse(String courseId, String studentId) throws SQLException;

    /**
     * View courses
     *
     * @return list of courses
     * @throws SQLException
     */
    List<Course> viewCourse() throws SQLException;

    /**
     * view registered courses
     *
     * @param studentId
     * @return list of registered courses
     * @throws SQLException
     */
    List<Course> viewRegisterCourse(String studentId) throws SQLException;

    /**
     * calculate fees
     *
     * @param studentId
     * @return fees
     * @throws SQLException
     */
    double calculate(String studentId) throws SQLException;

    /**
     * view number of registered courses
     *
     * @param studentId
     * @return number of registered courses
     * @throws SQLException
     */
    int numOfRegisteredCourses(String studentId) throws SQLException;

    /**
     * view number of registered courses
     *
     * @param studentId
     * @return true/false
     * @throws SQLException
     */
    boolean isRegistered(String courseId, String studentId) throws SQLException;


}
