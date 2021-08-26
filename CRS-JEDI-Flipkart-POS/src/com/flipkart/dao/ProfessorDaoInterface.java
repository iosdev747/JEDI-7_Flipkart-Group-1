package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student ;
import com.flipkart.exception.GradeNotAddedException ;

public interface ProfessorDaoInterface {

    public List<Course> getCoursesByProfessor(int professorEmpId);

    public List<EnrolledStudent> getEnrolledStudent(int professorEmpId);

    public boolean addGrade(int studentId, String courseId, double grade) throws GradeNotAddedException;

    public String getProfessorName(int professorEmpId) ;

    public boolean verifyProfessor(int userId);

    public int getProfessorId(int userId);
}
