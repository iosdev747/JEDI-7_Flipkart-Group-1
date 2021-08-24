package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

public interface StudentInterface {

    Grade getGrade(String studentId, String courseId);

    Course[] viewCourse(String studentId);

    boolean enrollCourse(String courseId, String studentId);

    boolean dropCourse(String courseId, String studentId);

    Student getStudentObject(int userId);

}
