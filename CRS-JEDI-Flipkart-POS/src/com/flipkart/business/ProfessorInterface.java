package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;

import java.sql.SQLException;
import java.util.List;

public interface ProfessorInterface {

    // give the list of course by professor

    /**
     * Method to get list of all courses a professor is teaching
     *
     * @param professorEmpId
     * @return List of courses the professor is teaching
     */
    List<Course> getCoursesByProfessor(String professorEmpId);

    /**
     * Method to view all the enrolled students
     *
     * @param professorEmpId
     * @return List of enrolled students
     */
    List<EnrolledStudent> getEnrolledStudent(String professorEmpId) throws SQLException;

    /**
     * Method to grade a Student
     *
     * @param studentId
     * @param courseId
     * @param grade
     * @return boolean indicating if grade is added or not
     * @throws GradeNotAddedException
     */
    boolean addGrade(String studentId, String courseId, double grade) throws GradeNotAddedException;

    /**
     * Method to get the name of the Professor
     *
     * @param professorEmpId
     * @return Name of the Professor
     */
    String getProfessorName(String professorEmpId);

    /**
     * Method to verify the User is a Professor
     *
     * @param userId
     * @return
     */
    boolean verifyProfessor(int userId);

    /**
     * Method to get the ProfessorId from UserId
     *
     * @param userId
     * @return professorId
     */
    String getProfessorId(int userId);
}
