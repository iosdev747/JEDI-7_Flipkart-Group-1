package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student ;
import com.flipkart.exception.GradeNotAddedException ;

public interface ProfessorDaoInterface {

    // give the courses taught by professor
    public List<Course> getCoursesByProfessor(String professorEmpId);

    public List<EnrolledStudent> getEnrolledStudent(String professorEmpId);

    public boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    public String getProfessorName(String professorEmpId) ;

    public boolean verifyProfessor(int userId);

    public String getProfessorId(int userId);
}
