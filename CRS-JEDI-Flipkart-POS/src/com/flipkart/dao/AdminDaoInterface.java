package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;

import java.util.List;


public interface AdminDaoInterface {

    /**
     * Method to delete course
     *
     * @param courseId
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     */
    void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException;

    /**
     * Method to add course
     *
     * @param course
     * @throws CourseFoundException
     */
    void addCourse(Course course) throws CourseFoundException;

    /**
     * Method to view pending admissions
     *
     * @return list of students
     */
    // this two depend on the isApproved in DB which is not in student
    List<Student> viewPendingAdmissions();

    /**
     * Method to approve student registration
     *
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */
    void approveStudent(String studentId) throws StudentNotFoundForApprovalException;

    /**
     * Method to add professor
     *
     * @param professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to add user
     *
     * @param user
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to assign course
     *
     * @param courseId
     * @param professorEmpId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    /**
     * Method to view professors list
     *
     * @return list of professors
     */
    List<Professor> viewProfessor();

    /**
     * Method to verify professor
     *
     * @param userId
     * @return true/false
     */
    boolean verifyAdmin(int userId);

    /**
     * Method to get admin ID
     *
     * @param userId
     * @return admin id
     */
    String getAdminId(int userId);

}