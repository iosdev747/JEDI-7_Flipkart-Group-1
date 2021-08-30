package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;

import java.util.List;

public interface ProfessorDaoInterface {

    // give the courses taught by professor
    List<Course> getCoursesByProfessor(String professorEmpId);

    List<EnrolledStudent> getEnrolledStudent(String professorEmpId);

    boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    String getProfessorName(String professorEmpId);

    boolean verifyProfessor(int userId);

    String getProfessorId(int userId);
}
