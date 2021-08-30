package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;

import java.util.List;


public class AdminOperation implements AdminInterface {

    /**
     * Constructor
     */
    public AdminOperation() {   // In future may be change to private
    }

    /**
     * Method to delete course
     *
     * @param courseId
     * @return
     */
    @Override
    public void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Deleting Course " + courseId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();

        try {
            adminInterface.deleteCourse(courseId);
        } catch (CourseNotFoundException | CourseNotDeletedException e) {
            throw e;
        }
    }

    /**
     * Method to add course
     * @param courseId ID of the course
     * @param courseName name of the course
     * @param credit credits of the course
     * @param professorEmpId employee ID of the professor
     * @param fee fee of the course
     * @throws CourseFoundException
     */
    @Override
    public void addCourse(String courseId, String courseName, int credit, String professorEmpId, double fee) throws CourseFoundException {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Adding Course " + courseId);
        Course course = new Course(courseId, courseName, credit, professorEmpId, fee);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        try {
            adminInterface.addCourse(course);
        } catch (CourseFoundException e) {
            throw e;
        }
    }


    /**
     * Method to get list of pending approvals.
     * @return list of student with pending approval
     */
    @Override
    public List<Student> viewPendingAdmissions() {

        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        return adminDaoInterface.viewPendingAdmissions();

    }

    /**
     * Method to approve student
     * @param studentId ID of the student
     * @throws StudentNotFoundForApprovalException
     */
    @Override
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException {

        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();

        try {
            adminDaoInterface.approveStudent(studentId);
        } catch (StudentNotFoundForApprovalException e) {
            throw e;
        }
    }


    /**
     * Method to assign add professor
     * @param professor Professor object to add
     */
    @Override
    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Adding Professor " + professor.getProfessorEmpId());
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        try {
            adminInterface.addProfessor(professor);
        } catch (ProfessorNotAddedException | UserIdAlreadyInUseException e) {
            throw e;
        }
    }


    /**
     * Method to add a user
     * @param user User class object to add
     */
    @Override
    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Adding User " + user.getUserID());
        AdminDaoInterface adminInterface = new AdminDaoOperation();

        try {
            adminInterface.addUser(user);
        } catch (UserNotAddedException | UserIdAlreadyInUseException e) {
            throw e;
        }

    }

    /**
     * Method to assign course to professor
     * @param courseId ID of the course
     * @param professorEmpId Employee ID of the professor teaching this course
     * @throws CourseNotFoundException
     * @throws UserNotFoundException
     */
    @Override
    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Assigning Course " + courseId + " to professor with ID " + professorEmpId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        try {
            adminInterface.assignCourse(courseId, professorEmpId);
        } catch (CourseNotFoundException | UserNotFoundException e) {
            throw e;
        }
        //adminInterface.assignCourse(courseId, professorEmpId);
    }

    /**
     * Method to view list of professors
     * @return List of the professor
     */
    @Override
    public List<Professor> viewProfessor() {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Viewing Professors ");
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.viewProfessor();
    }

    /**
     * Method to get verify
     * @param userId ID of the user
     * @return true if user is Admin, else returns false
     */
    @Override
    public boolean verifyAdmin(int userId) {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Verifying Professor " + userId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.verifyAdmin(userId);
    }

    /**
     * Method to get adminID from userID
     * @param userId ID of the user
     * @return admin's user ID
     */
    @Override
    public String getAdminId(int userId) {
        Logger logger = Logger.getLogger(AdminOperation.class);
        logger.debug("Getting Admin with ID : " + userId);
        AdminDaoInterface adminInterface = new AdminDaoOperation();
        return adminInterface.getAdminId(userId);
    }

}
