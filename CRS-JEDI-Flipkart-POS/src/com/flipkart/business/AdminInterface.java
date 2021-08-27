package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;

public interface AdminInterface {
    /**
     * Method to Delete Course from Course Catalog
     *
     * @param courseId
     * @throws CourseNotFoundException
     * @throws CourseNotDeletedException
     */
    public void deleteCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException;

    /**
     * Method to add Course to Course Catalog
     *
     * @param courseId
     * @param courseName
     * @param credit
     * @param professorEmpId
     * @param fee
     */
    public void addCourse(String courseId, String courseName, int credit, String professorEmpId, double fee) throws CourseFoundException;


    // this two depend on the isApproved in DB which is not in student

    /**
     * Method to view Students yet to be approved by Admin
     *
     * @return List of Students with pending admissions
     */
    public List<Student> viewPendingAdmissions();

    /**
     * Method to approve a Student
     *
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException;

    /**
     * Method to add Professor to DB
     *
     * @param professor : Professor Object storing details of a professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to User to DB
     *
     * @param user : User Object storing details of a professor
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to assign Course to a Professor
     *
     * @param courseId
     * @param professorEmpId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    /**
     * View professor in the institute
     *
     * @return List of the professors in the institute
     */
    public List<Professor> viewProfessor();

    /**
     * Method to verify the user is a Admin
     *
     * @param userId
     * @return
     */
    public boolean verifyAdmin(int userId);

    /**
     * Method to get AdminId from UserId
     *
     * @param userId
     * @return adminId
     */
    public String getAdminId(int userId);

}
