package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;

public interface ProfessorDaoInterface {

    // give the courses taught by professor
    public List<Course> getCoursesByProfessor(int professorEmpId);

    public List<EnrolledStudent> getEnrolledStudent(int professorEmpId);

    public boolean addGrade(int studentId, String courseId, double grade);

    public String getProfessorName(int professorEmpId);

    public boolean verifyProfessor(int userId);

    public int getProfessorId(int userId);
}
