package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;

public class CourseOperation implements CourseInterface {

    @Override
    public ArrayList<Course> getCourseCatalog() {
        return null;
    }

    @Override
    public Course getCourseObject(String courseId) {
        return null;
    }

    @Override
    public Professor getProfessor(String courseId) {
        return null;
    }

    @Override
    public ArrayList<Student> getEnrolledStudents(String courseId) {
        return null;
    }

    @Override
    public boolean isAvailable(String courseId) {
        return false;
    }
}
