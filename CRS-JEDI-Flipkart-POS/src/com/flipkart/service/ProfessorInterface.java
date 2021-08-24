package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface ProfessorInterface {

    boolean addGrade(int studentId, String courseCode, String grade);

    boolean applyCourse(String courseId, int professorId);

    Course[] viewCourse(int professorId);

    Professor getProfessorObject(String professorId);

    Student[] viewEnrolledStudents(String courseId, String professorId);

}
