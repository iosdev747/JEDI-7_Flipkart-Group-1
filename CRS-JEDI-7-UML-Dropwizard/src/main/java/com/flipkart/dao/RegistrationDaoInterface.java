package com.flipkart.dao;

import com.flipkart.bean.Course;

import java.sql.SQLException;
import java.util.List;


public interface RegistrationDaoInterface {

    boolean addCourse(String courseId, String studentId) throws SQLException;

    boolean dropCourse(String courseId, String studentId) throws SQLException;

    List<Course> viewCourse() throws SQLException;

    List<Course> viewRegisterCourse(String studentId) throws SQLException;

    double calculate(String studentId) throws SQLException;

    int numOfRegisteredCourses(String studentId) throws SQLException;

    boolean isRegistered(String courseId, String studentId) throws SQLException;


}
