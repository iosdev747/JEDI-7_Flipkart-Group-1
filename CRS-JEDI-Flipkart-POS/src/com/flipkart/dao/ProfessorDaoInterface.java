package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student ;
import com.flipkart.exception.GradeNotAddedException ;

public interface ProfessorDaoInterface {

    /**
     * Get courses list taught by professor
     * @param professorEmpId
     * @return list of courses taught by professor
     */
    public List<Course> getCoursesByProfessor(String professorEmpId);

    /**
     * view list of enrolled students
     * @param professorEmpId
     * @return list of enrolled students
     */
    public List<EnrolledStudent> getEnrolledStudent(String professorEmpId);

    /**
     * add grade
     * @param studentId
     * @param courseId
     * @param grade
     * @return true/false
     * @throws GradeNotAddedException
     */
    public boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    /**
     * get professor name
     * @param professorEmpId
     * @return professor name
     */
    public String getProfessorName(String professorEmpId) ;

    /**
     * verify professor
     * @param userId
     * @return true/false
     */
    public boolean verifyProfessor(int userId);

    /**
     * get professor ID
     * @param userId
     * @return professor id
     */
    public String getProfessorId(int userId);
}
