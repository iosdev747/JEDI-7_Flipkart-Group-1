package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

import java.util.*;

public interface ProfessorInterface {

    // give the list of course by professor
    public List<Course> getCoursesByProfessor(int professorEmpId);

    public List<EnrolledStudent> getEnrolledStudent(int professorEmpId);

    public boolean addGrade(int studentId, String courseId, double grade);

    public String getProfessorName(int professorEmpId);

    public boolean verifyProfessor(int userId);

    public int getProfessorId(int userId);
}
