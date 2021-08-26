package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Course;

public interface RegistrationInterface {

    public boolean addCourse(String courseId, int studentId);

    public boolean dropCourse(String courseId, int studentId);

    public List<Course> viewCourse();

    public List<Course> viewRegisterCourse(int studentId);

    public double calculate(int studentId);

    public int numOfRegisteredCourses(int studentId);

    public boolean isRegistered(String courseId, int studentId);

}
