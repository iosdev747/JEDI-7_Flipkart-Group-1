package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;

import java.sql.SQLException;
import java.util.List;

public interface ProfessorInterface {

    /**
     * get courses by professor id
     *
     * @param professorEmpId
     * @return
     */
    // give the list of course by professor
    List<Course> getCoursesByProfessor(String professorEmpId);

    /**
     * get enrolled students
     *
     * @param professorEmpId
     * @return
     * @throws SQLException
     */
    List<EnrolledStudent> getEnrolledStudent(String professorEmpId) throws SQLException;

    /**
     * add grade
     *
     * @param studentId
     * @param courseId
     * @param grade
     * @return
     * @throws GradeNotAddedException
     */
    boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    /**
     * get professor name
     *
     * @param professorEmpId
     * @return
     */
    String getProfessorName(String professorEmpId);

    /**
     * verify professor
     *
     * @param userId
     * @return
     */
    boolean verifyProfessor(int userId);

    /**
     * Mehtod to get professor
     *
     * @param userId
     * @return
     */
    String getProfessorId(int userId);
}
