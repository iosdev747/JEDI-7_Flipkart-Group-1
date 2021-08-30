package com.flipkart.business;

import java.util.*;
import java.sql.SQLException;

import com.flipkart.exception.*;

import com.flipkart.bean.Course;

public interface RegistrationInterface {


    /**
     * add course
     * @param courseId
     * @param studentId
     * @return
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    public boolean addCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    /**
     * drop course
     * @param courseId
     * @param studentId
     * @return
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    public boolean dropCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    /**
     * view courses
     * @return
     * @throws SQLException
     */
    public List<Course> viewCourse() throws SQLException;

    /**
     * view registered courses
     * @param studentId
     * @return
     * @throws SQLException
     */
    public List<Course> viewRegisterCourse(String studentId) throws SQLException;

    /**
     * calculate fees
     * @param studentId
     * @return
     * @throws SQLException
     */
    public double calculate(String studentId) throws SQLException;

    /**
     * number of registered courses
     * @param studentId
     * @return
     * @throws SQLException
     */
    public int numOfRegisteredCourses(String studentId) throws SQLException;

    /**
     * if registered or not
     * @param courseId
     * @param studentId
     * @return
     * @throws SQLException
     */
    public boolean isRegistered(String courseId, String studentId) throws SQLException;

}
