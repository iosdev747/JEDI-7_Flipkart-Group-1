package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.*;


public interface AdminDaoInterface {

    public void deleteCourse(String courseId) throws CourseNotDeletedException, CourseNotFoundException;

    public void addCourse(Course course) throws CourseFoundException;


    // this two depend on the isApproved in DB which is not in student
    public List<Student> viewPendingAdmissions();


    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException;


    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

    public void assignCourse(String courseId, String professorEmpId) throws CourseNotFoundException, UserNotFoundException;

    public List<Professor> viewProfessor();

    public boolean verifyProfessor(int userId);

    public String getAdminId(int userId);

}