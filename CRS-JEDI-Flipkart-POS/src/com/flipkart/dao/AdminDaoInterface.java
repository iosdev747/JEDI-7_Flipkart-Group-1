package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;


public interface AdminDaoInterface {

    /**
     * Method to delete course
     * @param courseId
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     */
    public void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException;

    /**
     * Method to add course
     * @param course
     * @throws CourseFoundException
     */
    public void addCourse(Course course) throws CourseFoundException;

    /**
     * Method to view pending admissions
     * @return list of students
     */
    // this two depend on the isApproved in DB which is not in student
    public List<Student> viewPendingAdmissions();

    /**
     * Method to approve student registration
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException;

    /**
     * Method to add professor
     * @param professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to add user
     * @param user
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to assign course
     * @param courseId
     * @param professorEmpId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    /**
     * Method to view professors list
     * @return list of professors
     */
    public List<Professor> viewProfessor();

    /**
     * Method to verify professor
     * @param userId
     * @return true/false
     */
    public boolean verifyAdmin(int userId);

    /**
     * Method to get admin ID
     * @param userId
     * @return admin id
     */
    public String getAdminId(int userId);

}