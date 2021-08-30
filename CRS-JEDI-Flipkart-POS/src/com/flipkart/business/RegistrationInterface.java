package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface RegistrationInterface {
    /**
     * Method to add Course selected by student
     *
     * @param courseId
     * @param studentId
     * @return boolean indicating if the course is added successfully
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    boolean addCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    /**
     * Method to drop Course selected by student
     *
     * @param courseId
     * @param studentId
     * @return boolean indicating if the course is dropped successfully
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    boolean dropCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    /**
     * Method to view the list of available courses
     *
     * @return List of courses
     * @throws SQLException
     */
    List<Course> viewCourse() throws SQLException;

    /**
     * Method to view the list of courses registered by the student
     *
     * @param studentId
     * @return List of Recourses
     * @throws SQLException
     */
    List<Course> viewRegisterCourse(String studentId) throws SQLException;

    /**
     * Method to get the fee amount to be payed by student.
     *
     * @param studentId
     * @return Fees to be paid by student
     * @throws SQLException
     */
    double calculate(String studentId) throws SQLException;

    /**
     * Method to get the number of courses registered by the student
     *
     * @param studentId
     * @return Number of courses registered by the student
     * @throws SQLException
     */
    int numOfRegisteredCourses(String studentId) throws SQLException;

    /**
     * Method to view the Registration Status of a Student for a particular course
     *
     * @param studentId
     * @return
     * @throws SQLException
     * @paran courseId
     */
    boolean isRegistered(String courseId, String studentId) throws SQLException;

}
