package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;


public interface AdminDaoInterface {

    /**
     * delete course
     * @param courseId
     * @throws CourseNotDeletedException
     * @throws CourseNotFoundException
     */
    public void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException;

    /**
     * add course
     * @param course
     * @throws CourseFoundException
     */
    public void addCourse(Course course) throws CourseFoundException;

    /**
     * view pending approvals
     * @return
     */
    // this two depend on the isApproved in DB which is not in student
    public List<Student> viewPendingAdmissions();

    /**
     * approve student
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException;

    /**
     * add professor
     * @param professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * add user
     * @param user
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */
    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    /**
     * assign course
     * @param courseId
     * @param professorEmpId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    /**
     * list of professors
     * @return
     */
    public List<Professor> viewProfessor();

    /**
     * verify professor
     * @param userId
     * @return
     */
    public boolean verifyProfessor(int userId);

    /**
     * get admin id
     * @param userId
     * @return
     */
    public String getAdminId(int userId);

}