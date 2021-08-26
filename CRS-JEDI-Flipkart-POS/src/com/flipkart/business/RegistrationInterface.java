package com.flipkart.business;

import java.util.*;
import java.sql.SQLException;

import com.flipkart.exception.*;

import com.flipkart.bean.Course;

public interface RegistrationInterface {

    public boolean addCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    public boolean dropCourse(String courseId, String studentId) throws CourseNotFoundException, SQLException;

    public List<Course> viewCourse() throws SQLException;

    public List<Course> viewRegisterCourse(String studentId) throws SQLException;

    public double calculate(String studentId) throws SQLException;

    public int numOfRegisteredCourses(String studentId) throws SQLException;

    public boolean isRegistered(String courseId, String studentId) throws SQLException;

}