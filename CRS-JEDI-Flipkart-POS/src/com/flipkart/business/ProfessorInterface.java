package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.*;

import java.util.*;
import java.sql.*;

public interface ProfessorInterface {

    // give the list of course by professor
    public List<Course> getCoursesByProfessor(String professorEmpId);

    public List<EnrolledStudent> getEnrolledStudent(String professorEmpId) throws SQLException;

    public boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    public String getProfessorName(String professorEmpId);

    public boolean verifyProfessor(int userId);

    public String getProfessorId(int userId);
}
