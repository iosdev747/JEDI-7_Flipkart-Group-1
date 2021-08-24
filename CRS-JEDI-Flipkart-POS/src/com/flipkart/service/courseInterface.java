package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface courseInterface {

    Course[] getCourseCatalog();

    Course getCourseObject(String courseId);

    Professor getProfessor(String courseId);

    Student[] getEnrolledStudents(String courseId);

    boolean isAvailable(String courseId);

}
