package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;

import java.util.List;


public interface AdminDaoInterface {

    /**
     * delete course
     *
     * @param courseId
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     */
    void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException;

    /**
     * add course
     *
     * @param course
     * @throws CourseFoundException
     */
    void addCourse(Course course) throws CourseFoundException;

    /**
     * view pending approvals
     *
     * @return
     */
    // this two depend on the isApproved in DB which is not in student
    List<Student> viewPendingAdmissions();

    /**
     * approve student
     *
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */
    void approveStudent(String studentId) throws StudentNotFoundForApprovalException;

    /**
     * add professor
     *
     * @param professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * add user
     *
     * @param user
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    /**
     * assign course
     *
     * @param courseId
     * @param professorEmpId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    /**
     * list of professors
     *
     * @return
     */
    List<Professor> viewProfessor();

    /**
     * verify admin
     *
     * @param userId
     * @return
     */
    boolean verifyAdmin(int userId);

    /**
     * get admin id
     *
     * @param userId
     * @return
     */
    String getAdminId(int userId);

}