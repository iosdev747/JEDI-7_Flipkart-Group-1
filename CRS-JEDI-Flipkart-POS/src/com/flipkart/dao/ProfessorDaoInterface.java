package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;

import java.util.List;

public interface ProfessorDaoInterface {

    /**
     * Get courses list taught by professor
     *
     * @param professorEmpId
     * @return list of courses taught by professor
     */
    List<Course> getCoursesByProfessor(String professorEmpId);

    /**
     * view list of enrolled students
     *
     * @param professorEmpId
     * @return list of enrolled students
     */
    List<EnrolledStudent> getEnrolledStudent(String professorEmpId);

    /**
     * add grade
     *
     * @param studentId
     * @param courseId
     * @param grade
     * @return true/false
     * @throws GradeNotAddedException
     */
    boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    /**
     * get professor name
     *
     * @param professorEmpId
     * @return professor name
     */
    String getProfessorName(String professorEmpId);

    /**
     * verify professor
     *
     * @param userId
     * @return true/false
     */
    boolean verifyProfessor(int userId);

    /**
     * get professor ID
     *
     * @param userId
     * @return professor id
     */
    String getProfessorId(int userId);
}
