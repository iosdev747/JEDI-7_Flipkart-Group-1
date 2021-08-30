package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;

import java.util.List;

public interface AdminInterface {
    /**
     * Method to Delete Course from Course Catalog
     *
     * @param courseId
     * @throws CourseNotFoundException
     * @throws CourseNotDeletedException
     */
    void deleteCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException;

    /**
     * Method to add Course to Course Catalog
     *
     * @param courseId
     * @param courseName
     * @param credit
     * @param fee
     * @param professorEmpId
     * @throws CourseNotFoundException
     */
    void addCourse(String courseId, String courseName, int credit, String professorEmpId, double fee) throws CourseFoundException;


    // this two depend on the isApproved in DB which is not in student

    /**
     * Method to view Students yet to be approved by Admin
     *
     * @return List of Students with pending admissions
     */
    List<Student> viewPendingAdmissions();

    /**
     * Method to approve a Student
     *
     * @param studentId
     * @throws StudentNotFoundForApprovalException
     */

    void approveStudent(String studentId) throws StudentNotFoundForApprovalException;

    /**
     * Method to add Professor to DB
     *
     * @param professor : Professor Object storing details of a professor
     * @throws ProfessorNotAddedException
     * @throws UserIdAlreadyInUseException
     */


    void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to add User to DB
     *
     * @param user: Professor Object storing details of a user
     * @throws UserNotAddedException
     * @throws UserIdAlreadyInUseException
     */

    void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to assign Course to a Professor
     *
     * @param courseId
     * @param professorEmpId
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */

    void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    /**
     * View professor in the institute
     *
     * @return List of the professors in the institute
     */
    List<Professor> viewProfessor();

    /**
     * Method to verify that the user is a Admin
     *
     * @param userId
     * @return
     */

    boolean verifyAdmin(int userId);

    /**
     * To get AdminId from userId
     *
     * @return AdminId
     */

    String getAdminId(int userId);

    /**
     * To get all the course list
     *
     * @return course list
     */
    List<Course> viewCourse();
}
