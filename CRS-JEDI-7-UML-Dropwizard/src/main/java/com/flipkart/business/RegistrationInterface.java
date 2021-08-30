package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface RegistrationInterface {


    /**
     * add course
     *
     * @param courseId
     * @param studentId
     * @return
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    boolean addCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    /**
     * drop course
     *
     * @param courseId
     * @param studentId
     * @return
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    boolean dropCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    /**
     * view courses
     *
     * @return
     * @throws SQLException
     */
    List<Course> viewCourse() throws SQLException;

    /**
     * view registered courses
     *
     * @param studentId
     * @return
     * @throws SQLException
     */
    List<Course> viewRegisterCourse(String studentId) throws SQLException;

    /**
     * calculate fees
     *
     * @param studentId
     * @return
     * @throws SQLException
     */
    double calculate(String studentId) throws SQLException;

    /**
     * number of registered courses
     *
     * @param studentId
     * @return
     * @throws SQLException
     */
    int numOfRegisteredCourses(String studentId) throws SQLException;

    /**
     * if registered or not
     *
     * @param courseId
     * @param studentId
     * @return
     * @throws SQLException
     */
    boolean isRegistered(String courseId, String studentId) throws SQLException;

}
