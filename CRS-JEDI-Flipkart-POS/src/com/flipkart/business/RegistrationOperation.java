package com.flipkart.business;

import java.sql.SQLException;
import java.util.*;

import com.flipkart.bean.Course;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import org.apache.log4j.Logger;

public class RegistrationOperation implements RegistrationInterface {

    public RegistrationOperation() {   // In future may be change to private
    }

    /**
     * Method to add Course selected by student
     *
     * @param courseId
     * @param studentId
     * @return boolean indicating if the course is added successfully
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    @Override
    public boolean addCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException {
        Logger logger = Logger.getLogger(RegistrationOperation.class);
        logger.debug("Adding Course with ID: " + courseId + " for Student with ID : " + studentId);
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        if (registrationInterface.isRegistered(courseId, studentId)) {
            return false;
        }
        try {
            return registrationInterface.addCourse(courseId, studentId);
        } catch (Exception e) {
            throw new CourseNotFoundException(courseId);
        }
    }

    /**
     * Method to drop Course selected by student
     *
     * @param courseId
     * @param studentId
     * @return boolean indicating if the course is dropped successfully
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    @Override
    public boolean dropCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException {
        Logger logger = Logger.getLogger(RegistrationOperation.class);
        logger.debug("Dropping Course with ID: " + courseId + " for Student with ID : " + studentId);

        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        try {
            return registrationInterface.dropCourse(courseId, studentId);
        } catch (Exception e) {
            throw new CourseNotFoundException(courseId);
        }
    }

    /**
     * Method to view the list of available courses
     *
     * @return List of courses
     * @throws SQLException
     */
    @Override
    public List<Course> viewCourse() throws SQLException {
        Logger logger = Logger.getLogger(RegistrationOperation.class);
        logger.debug("Viewing Course list ");
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.viewCourse();
    }

    /**
     * Method to view the list of courses registered by the student
     *
     * @param studentId
     * @return List of Recourses
     * @throws SQLException
     */
    @Override
    public List<Course> viewRegisterCourse(String studentId) throws SQLException {
        Logger logger = Logger.getLogger(RegistrationOperation.class);
        logger.debug(" Viewing Registerd Courses for Student with ID : " + studentId);
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.viewRegisterCourse(studentId);
    }

    /**
     * Method to get the fee amount to be paid by student.
     *
     * @param studentId
     * @return Fees to be paid by student
     * @throws SQLException
     */
    @Override
    public double calculate(String studentId) throws SQLException {
        Logger logger = Logger.getLogger(RegistrationOperation.class);
        logger.debug("Calculating fees for Student with ID : " + studentId);
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.calculate(studentId);
    }

    /**
     * Method to get the number of courses registered by the student
     *
     * @param studentId
     * @return Number of courses registered by the student
     * @throws SQLException
     */
    @Override
    public int numOfRegisteredCourses(String studentId) throws SQLException {
        Logger logger = Logger.getLogger(RegistrationOperation.class);
        logger.debug(" Getting number of registered courses for Student with ID : " + studentId);
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.numOfRegisteredCourses(studentId);
    }

    /**
     * Method to view the Registration Status of a Student for a particular course
     *
     * @param studentId
     * @return
     * @throws SQLException
     * @paran courseId
     */
    @Override
    public boolean isRegistered(String courseId, String studentId) throws SQLException {
        Logger logger = Logger.getLogger(RegistrationOperation.class);
        logger.debug("Checking if Course with ID: " + courseId + "is registered for Student with ID : " + studentId);
        RegistrationDaoInterface registrationInterface = new RegistrationDaoOperation();
        return registrationInterface.isRegistered(courseId, studentId);
    }
}
