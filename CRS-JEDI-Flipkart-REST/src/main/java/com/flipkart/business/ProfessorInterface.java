package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.*;

import java.util.*;
import java.sql.*;

public interface ProfessorInterface {

    /**
     * get courses by professor id
     * @param professorEmpId
     * @return
     */
    // give the list of course by professor
    public List<Course> getCoursesByProfessor(String professorEmpId);

    /**
     * get enrolled students
     * @param professorEmpId
     * @return
     * @throws SQLException
     */
    public List<EnrolledStudent> getEnrolledStudent(String professorEmpId) throws SQLException;

    /**
     * add grade
     * @param studentId
     * @param courseId
     * @param grade
     * @return
     * @throws GradeNotAddedException
     */
    public boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    /**
     * get professor name
     * @param professorEmpId
     * @return
     */
    public String getProfessorName(String professorEmpId);

    /**
     * verify professor
     * @param userId
     * @return
     */
    public boolean verifyProfessor(int userId);

    /**
     * Mehtod to get professor
     * @param userId
     * @return
     */
    public String getProfessorId(int userId);
}
