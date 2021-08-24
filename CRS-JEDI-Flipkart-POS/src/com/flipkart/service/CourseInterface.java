package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;

public interface CourseInterface {

    ArrayList<Course> getCourseCatalog();

    Course getCourseObject(String courseId);

    Professor getProfessor(String courseId);

    ArrayList<Student> getEnrolledStudents(String courseId);

    boolean isAvailable(String courseId);

}
