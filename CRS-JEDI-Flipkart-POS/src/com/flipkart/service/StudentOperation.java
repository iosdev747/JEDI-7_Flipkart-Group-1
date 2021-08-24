package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.ArrayList;

public class StudentOperation implements StudentInterface{
    @Override
    public Grade getGrade(String studentId, String courseId) {
        return null;
    }

    @Override
    public ArrayList<Course> viewRegisteredCourse(String studentId) {
        return null;
    }

    @Override
    public boolean enrollCourse(String courseId, String studentId) {
        return false;
    }

    @Override
    public boolean dropCourse(String courseId, String studentId) {
        return false;
    }

    @Override
    public Student getStudentObject(int userId) {
        return null;
    }
}
