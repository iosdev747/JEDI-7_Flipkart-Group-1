package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

import java.util.List;

public interface AdminInterface {

    boolean deleteCourse(String courseId);

    boolean addCourse(Course course);

    boolean verifyStudentProfile(String studentId);

    boolean addProfessor(Professor professor);

    List<Course> viewCourses(int catalogId);

    List<Professor> viewProfessors();
}
